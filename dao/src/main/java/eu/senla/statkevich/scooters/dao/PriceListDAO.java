package eu.senla.statkevich.scooters.dao;

import eu.senla.statkevich.scooters.entity.PriceList;
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
public class PriceListDAO extends GenericDaoImpl<PriceList> implements IPriceListDao{

    private static final Logger logger = Logger.getLogger(PriceListDAO.class);

    @Override
    public PriceList readByUser(Users user) {
        CriteriaBuilder cb=entityManager.getCriteriaBuilder();
        CriteriaQuery<PriceList> cq=cb.createQuery(PriceList.class);
        Root<PriceList> priceListRoot = cq.from(PriceList.class);

//        Predicate scooterByModel = cb.equal(scooters.get("model"), model);
//        cq.where(scooterByModel);
//
//        logger.info("AAAAA  "+entityManager.createQuery(cq).getMaxResults());
//
//        return entityManager.createQuery(cq).getSingleResult();

        return null;
    }

    @Override
    public List<PriceList> readAll() {
        CriteriaBuilder cb=entityManager.getCriteriaBuilder();
        CriteriaQuery<PriceList> cq=cb.createQuery(PriceList.class);
        Root<PriceList> priceListRoot = cq.from(PriceList.class);

        CriteriaQuery<PriceList> all = cq.select(priceListRoot);

        return entityManager.createQuery(all).getResultList();
    }


}
