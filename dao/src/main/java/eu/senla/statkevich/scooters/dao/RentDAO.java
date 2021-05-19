package eu.senla.statkevich.scooters.dao;

import eu.senla.statkevich.scooters.entity.PriceList;
import eu.senla.statkevich.scooters.entity.Rent;
import eu.senla.statkevich.scooters.entity.Users;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class RentDAO extends GenericDaoImpl<Rent> implements IRentDao {

    @Override
    public List<Rent> readByUserId(Long id) {

        CriteriaBuilder cb=entityManager.getCriteriaBuilder();
        CriteriaQuery<Rent> cq=cb.createQuery(Rent.class);
        Root<Rent> rentRoot = cq.from(Rent.class);

        Predicate userById = cb.equal(rentRoot.get("user"), id);
        cq.where(userById);

        return entityManager.createQuery(cq).getResultList();
    }

    @Override
    public List<Rent> readAll() {
        CriteriaBuilder cb=entityManager.getCriteriaBuilder();
        CriteriaQuery<Rent> cq=cb.createQuery(Rent.class);
        Root<Rent> rentRoot = cq.from(Rent.class);

        CriteriaQuery<Rent> all = cq.select(rentRoot);

        return entityManager.createQuery(all).getResultList();
    }

    @Override
    public Rent create(Rent rent) {
        entityManager.persist(rent);
        return rent;
    }

    //    @Override
//    public Users read(final Long id) {
//        return entityManager.find(Users.class, id);
//    }
//
//    //@Override
//    public Users readByName(final String name) {
//        CriteriaBuilder cb=entityManager.getCriteriaBuilder();
//        CriteriaQuery<Users> cq=cb.createQuery(Users.class);
//        Root<Users> user = cq.from(Users.class);
//
//        Predicate userByName = cb.equal(user.get("name"), name);
//        cq.where(userByName);
//
//        return entityManager.createQuery(cq).getSingleResult();
//        //return (Users) entityManager.createQuery("Select r from Users r where r.name=?1").setParameter(1,name).getSingleResult();
//    }
//
//    @Override
//    public Users create(Users user) {
//        entityManager.persist(user);
//        return user;
//    }


}
