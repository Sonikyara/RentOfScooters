package eu.senla.statkevich.scooters.dao;

import eu.senla.statkevich.scooters.entity.PriceList;
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
    public PriceList readByTermAndScooter(Long term_id, Long scootersNumber) {
        CriteriaBuilder cb=entityManager.getCriteriaBuilder();
        CriteriaQuery<PriceList> cq=cb.createQuery(PriceList.class);
        Root<PriceList> priceListRoot = cq.from(PriceList.class);

        Predicate priceByTitle = cb.equal(priceListRoot.get("termOfRent"), term_id);
        Predicate priceByScooter = cb.equal(priceListRoot.get("scooter"), scootersNumber);
        Predicate all=cb.and(priceByTitle,priceByScooter);

        cq.where(all);

        return entityManager.createQuery(cq).getSingleResult();

    }

    @Override
    public PriceList read(Long id) {
        return entityManager.find(PriceList.class, id);
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
