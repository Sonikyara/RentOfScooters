package eu.senla.statkevich.dao.implementations;

import eu.senla.statkevich.dao.dao.IUserDao;
import eu.senla.statkevich.scooters.entities.Users;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.*;
import java.util.List;

@Repository
public class UserDAO extends GenericDaoImpl<Users> implements IUserDao {

    private static final Logger logger = Logger.getLogger(UserDAO.class);

    @Override
    public Users read(final Long id) {
        return entityManager.find(Users.class, id);
    }

    @Override
    public Users readByPhone(String phone) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Users> cq = cb.createQuery(Users.class);
        Root<Users> user = cq.from(Users.class);

        user.fetch("role", JoinType.INNER);

        Predicate userByPhone = cb.equal(user.get("phoneNumber"), phone);
        cq.where(userByPhone);

        return entityManager.createQuery(cq).getSingleResult();
    }

    @Override
    public Users readByName(final String name) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Users> cq = cb.createQuery(Users.class);
        Root<Users> user = cq.from(Users.class);

        user.fetch("role", JoinType.INNER);

        Predicate userByName = cb.equal(user.get("name"), name);
        cq.where(userByName);

        logger.info("dao");

        return entityManager.createQuery(cq).getSingleResult();
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
