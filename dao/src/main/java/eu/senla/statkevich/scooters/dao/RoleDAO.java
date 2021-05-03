package eu.senla.statkevich.scooters.dao;

import eu.senla.statkevich.scooters.entity.Roles;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
//public class RoleDAO implements IGenericDao<Roles>{
public class RoleDAO implements IRoleDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Roles read(final Long id) {
        return entityManager.find(Roles.class, id);
    }

    public Roles readByTitle(final String title) {
//        List<Roles> rolesList=entityManager.createQuery("Select * from roles where title=?1").setParameter(1,title).getResultList();
//        return rolesList.iterator().hasNext()?rolesList.iterator().next():null;
        return (Roles) entityManager.createQuery("Select r from Roles r where r.title=?1").setParameter(1,title).getSingleResult();
    }

    @Override
    //@Transactional
    public Roles create(Roles role) {
        entityManager.persist(role);
        return role;
    }

}
