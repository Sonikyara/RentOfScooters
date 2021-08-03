package eu.senla.statkevich.dao.implementations;

import eu.senla.statkevich.dao.dao.IRoleDao;
import eu.senla.statkevich.scooters.entities.Roles;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
public class RoleDAO extends GenericDaoImpl<Roles> implements IRoleDao { //

    @Override
    public Roles read(final Long id) {
        //native query
        Query query = entityManager.createNativeQuery("SELECT * FROM roles WHERE id=?1", Roles.class);
        query.setParameter(1, id);
        return (Roles) query.getSingleResult();
    }

    @Override
    public Roles readByTitle(final String title) {
        //native query
        Query query = entityManager.createNativeQuery("SELECT * FROM roles WHERE title=?1", Roles.class);
        query.setParameter(1, title);

        return (Roles) query.getSingleResult();
    }

    @Override
    public Roles create(Roles role) {
        entityManager.persist(role);
        return role;
    }

    @Override
    public List<Roles> readAll() {
        return null;
    }
}
