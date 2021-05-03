package eu.senla.statkevich.scooters.dao;

import eu.senla.statkevich.scooters.entity.Roles;
import eu.senla.statkevich.scooters.entity.Users;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
public class UserDAO implements IUserDao{//implements IGenericDao<Users>{

    @PersistenceContext
    private EntityManager entityManager;

    //@Transactional
    @Override
    public Users read(final Long id) {
        return entityManager.find(Users.class, id);
    }

    @Override
    public Users readByName(final String name) {
        return (Users) entityManager.createQuery("Select r from Users r where r.name=?1").setParameter(1,name).getSingleResult();
    }

    //@Transactional
    @Override
    public Users create(Users user) {
        entityManager.persist(user);
        return user;
    }

}
