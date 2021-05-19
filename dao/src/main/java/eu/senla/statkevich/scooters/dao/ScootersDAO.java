package eu.senla.statkevich.scooters.dao;

import eu.senla.statkevich.scooters.entity.Scooters;
import eu.senla.statkevich.scooters.entity.Users;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class ScootersDAO extends GenericDaoImpl<Scooters> implements IScooterDao{

    private static final Logger logger = Logger.getLogger(ScootersDAO.class);

    @Override
    public Scooters read(final Long number) {
        return entityManager.find(Scooters.class, number);
    }

    @Override
    public Scooters readByModel(String model) {
        //entityManager.clear();
        CriteriaBuilder cb=entityManager.getCriteriaBuilder();
        CriteriaQuery<Scooters> cq=cb.createQuery(Scooters.class);
        Root<Scooters> scooters = cq.from(Scooters.class);

        Predicate scooterByModel = cb.equal(scooters.get("model"), model);
        cq.where(scooterByModel);

        //logger.info("AAAAA  "+entityManager.createQuery(cq).getMaxResults());

        return entityManager.createQuery(cq).getSingleResult();
        //return entityManager.createQuery("Select r from Scooters r where r.model=?1",Scooters.class).setParameter(1,model).getSingleResult();
    }

    @Override
    public List<Scooters> readAll() {
        CriteriaBuilder cb=entityManager.getCriteriaBuilder();
        CriteriaQuery<Scooters> cq=cb.createQuery(Scooters.class);
        Root<Scooters> root = cq.from(Scooters.class);

        CriteriaQuery<Scooters> all = cq.select(root);

        return entityManager.createQuery(all).getResultList();
        //return  entityManager.createQuery("Select s from Scooters s").getResultList();
    }


}
