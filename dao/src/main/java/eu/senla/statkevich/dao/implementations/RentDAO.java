package eu.senla.statkevich.dao.implementations;

import eu.senla.statkevich.dao.dao.IRentDao;
import eu.senla.statkevich.scooters.entities.Rent;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.*;
import java.util.List;

@Repository
public class RentDAO extends GenericDaoImpl<Rent> implements IRentDao {

    private static final Logger logger = Logger.getLogger(RentDAO.class);

    @Override
    public List<Rent> readByUserId(Long id) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Rent> cq = cb.createQuery(Rent.class);
        Root<Rent> rentRoot = cq.from(Rent.class);

        Predicate userById = cb.equal(rentRoot.get("user"), id);
        cq.where(userById);

        rentRoot.fetch("user", JoinType.INNER);
        rentRoot.fetch("scooter", JoinType.INNER);
        rentRoot.fetch("price", JoinType.INNER);

        cq.orderBy(cb.desc(rentRoot.get("dateEnd")));

        return entityManager.createQuery(cq).getResultList();
    }

    @Override
    public Rent readByUserScooter(Long id, Long number) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Rent> cq = cb.createQuery(Rent.class);
        Root<Rent> rentRoot = cq.from(Rent.class);

        rentRoot.fetch("user", JoinType.INNER);
        rentRoot.fetch("scooter", JoinType.INNER);
        rentRoot.fetch("price", JoinType.INNER);

        Predicate[] predicates = new Predicate[3];
        predicates[0] = cb.equal(rentRoot.get("user"), id);
        predicates[1] = cb.equal(rentRoot.get("scooter"), number);
        predicates[2] = cb.isNull(rentRoot.get("dateEnd"));

        logger.info("user " + id + " scooter " + number);

        cq.select(rentRoot).where(predicates);
        List<Rent> resultList=entityManager.createQuery(cq).getResultList();
        if (resultList.size() !=0) {
            return resultList.get(0);
        }else{
            return null;
        }

    }

    @Override
    public Rent updateDateEnd(Rent rent) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaUpdate<Rent> criteriaUpdate = cb.createCriteriaUpdate(Rent.class);
        Root<Rent> root = criteriaUpdate.from(Rent.class);
        criteriaUpdate.set("dateEnd", rent.getDateEnd());
        criteriaUpdate.where(cb.equal(root.get("id"), rent.getId()));

        entityManager.createQuery(criteriaUpdate).executeUpdate();
        return rent;
    }

    @Override
    public List<Rent> readAll() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Rent> cq = cb.createQuery(Rent.class);
        Root<Rent> rentRoot = cq.from(Rent.class);

        rentRoot.fetch("user", JoinType.INNER);
        rentRoot.fetch("scooter", JoinType.INNER);
        rentRoot.fetch("price", JoinType.INNER);

        CriteriaQuery<Rent> all = cq.select(rentRoot);

        return entityManager.createQuery(all).getResultList();
    }

    @Override
    public Rent create(Rent rent) {
        entityManager.persist(rent);
        return rent;
    }
}
