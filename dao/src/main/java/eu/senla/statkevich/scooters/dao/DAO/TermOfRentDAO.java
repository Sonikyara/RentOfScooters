package eu.senla.statkevich.scooters.dao.DAO;

import eu.senla.statkevich.scooters.dao.IDao.ITermOfRentDao;
import eu.senla.statkevich.scooters.entity.entities.TermOfRent;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class TermOfRentDAO extends GenericDaoImpl<TermOfRent> implements ITermOfRentDao {

    @Override
    public TermOfRent readByTitle(String title) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<TermOfRent> cq = cb.createQuery(TermOfRent.class);
        Root<TermOfRent> termOfRentRoot = cq.from(TermOfRent.class);

        Predicate termByTitle = cb.equal(termOfRentRoot.get("title"), title);
        cq.where(termByTitle);

        return entityManager.createQuery(cq).getSingleResult();
    }

    @Override
    public List<TermOfRent> readAll() {
        return null;
    }

    @Override
    public TermOfRent read(Long id) {
        return entityManager.find(TermOfRent.class, id);
    }

}
