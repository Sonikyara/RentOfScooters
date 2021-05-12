package eu.senla.statkevich.scooters.dao;

import eu.senla.statkevich.scooters.entity.Roles;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
//public class RoleDAO  implements IRoleDao{

//public class RoleDAO implements IGenericDao<Roles>{
public class RoleDAO extends GenericDaoImpl<Roles>  implements IRoleDao{ //

//    @PersistenceContext
//    private EntityManager entityManager;

    @Override
    public Roles read(final Long id) {
        //super.getEntityManager()

        return entityManager.find(Roles.class, id);
    }

    @Override
    public Roles readByTitle(final String title) {

        CriteriaBuilder cb=entityManager.getCriteriaBuilder();
        CriteriaQuery<Roles> cq=cb.createQuery(Roles.class);//тип возвращаемых данных
        Root<Roles> role = cq.from(Roles.class);//корневой объект, от которого производится обход дерева свойств при накладывании
                                                // ограничений или указании что выбирать.
        Predicate roleByTitle = cb.equal(role.get("title"), title);
        cq.where(roleByTitle);

        return entityManager.createQuery(cq).getSingleResult();
        //return (Roles) entityManager.createQuery("Select r from Roles r where r.title=?1").setParameter(1,title).getSingleResult();
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
