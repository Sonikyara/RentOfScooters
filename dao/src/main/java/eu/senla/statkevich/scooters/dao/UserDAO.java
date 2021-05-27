package eu.senla.statkevich.scooters.dao;

import eu.senla.statkevich.scooters.dao.IDao.IUserDao;
import eu.senla.statkevich.scooters.entity.Users;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
//public class UserDAO implements IUserDao{
public class UserDAO extends GenericDaoImpl<Users> implements IUserDao {

    @Override
    public Users read(final Long id) {
        return entityManager.find(Users.class, id);
    }

    @Override
    public Users readByName(final String name) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Users> cq = cb.createQuery(Users.class);
        Root<Users> user = cq.from(Users.class);

        Predicate userByName = cb.equal(user.get("name"), name);
        cq.where(userByName);

        return entityManager.createQuery(cq).getSingleResult();
        //return (Users) entityManager.createQuery("Select r from Users r where r.name=?1").setParameter(1,name).getSingleResult();
    }

    @Override
    public Users create(Users user) {

        entityManager.persist(user);
        return user;
    }

    @Override
    public List<Users> readAll() {
        return entityManager.createQuery("Select u from Users u").getResultList();

    }

}
