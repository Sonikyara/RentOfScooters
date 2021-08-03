package eu.senla.statkevich.dao.implementations;

import eu.senla.statkevich.dao.dao.IScooterDao;
import eu.senla.statkevich.scooters.entities.Scooters;
import eu.senla.statkevich.scooters.entities.TypesProducers;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.criteria.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ScootersDAO extends GenericDaoImpl<Scooters> implements IScooterDao {

    private static final Logger logger = Logger.getLogger(ScootersDAO.class);

    @Override
    public Scooters read(final Long number) {
        return entityManager.find(Scooters.class, number);
    }

    @Override
    public Scooters readByModel(String model) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Scooters> cq = cb.createQuery(Scooters.class);
        Root<Scooters> scooters = cq.from(Scooters.class);

        scooters.fetch("seller", JoinType.INNER);
        Fetch<Scooters, TypesProducers> typeProducer = scooters.fetch("typeProducer", JoinType.INNER);
        scooters.fetch("typeProducer", JoinType.INNER).fetch("producer", JoinType.INNER);
        scooters.fetch("typeProducer", JoinType.INNER).fetch("scootersType", JoinType.INNER);

        Predicate scooterByModel = cb.equal(scooters.get("model"), model);
        cq.where(scooterByModel);

        return entityManager.createQuery(cq).getSingleResult();
    }

    @Override
    public List<Scooters> readAll() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Scooters> cq = cb.createQuery(Scooters.class);
        Root<Scooters> scooters = cq.from(Scooters.class);

        scooters.fetch("seller", JoinType.INNER);
        Fetch<Scooters, TypesProducers> typeProducer = scooters.fetch("typeProducer", JoinType.INNER);
        scooters.fetch("typeProducer", JoinType.INNER).fetch("producer", JoinType.INNER);
        scooters.fetch("typeProducer", JoinType.INNER).fetch("scootersType", JoinType.INNER);

        CriteriaQuery<Scooters> all = cq.select(scooters);

        return entityManager.createQuery(all).getResultList();
    }

    @Override
    public List<Scooters> readFree(LocalDate date) {
        logger.info(date);

        String myQuery =
                "select eu.senla.statkevich.entity.scooters.* from eu.senla.statkevich.entity.scooters left join" +
                        "(" +
                        "        select rentWithTermId.scooter_number,rentWithTermId.date_start,rentWithTermId.date_end," +
                        "        term_of_rent.count_of_days,rentWithTermId.date_start +term_of_rent.count_of_days*interval'1 day' as date_must_end from" +
                        "        (" +
                        "                select inRent.*,price_list.term_id from" +
                        "                                (" +
                        "                                        select * from rent where rent.date_end isnull" +
                        "                                ) as inRent " +
                        "                left join price_list on inRent.price_id=price_list.id" +
                        "        )as rentWithTermId " +
                        "left join term_of_rent on rentWithTermId.term_id=term_of_rent.id" +
                        ") as alldoRent on eu.senla.statkevich.entity.scooters.number=alldoRent.scooter_number" +
                        " where ((alldoRent.date_start isnull)or(alldoRent.date_must_end<='" + date + "')or(alldoRent.date_start>'" + date + "'))";


        logger.info(myQuery);
        Query query = entityManager.createNativeQuery(myQuery);

        List<Object[]> resultList = query.getResultList();

        List<Scooters> result = new ArrayList<>(resultList.size());
        for (Object[] row : resultList) {
            result.add(readByModel((String) row[1]));
        }

        return result;

    }


}
