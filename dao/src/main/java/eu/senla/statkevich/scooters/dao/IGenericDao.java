package eu.senla.statkevich.scooters.dao;

import eu.senla.statkevich.scooters.entity.Roles;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public interface IGenericDao<T>  {

    T read(final Long id);

    T create(final T entity);

//    T readByNameTitle(final String title);
//    List<T> readAll();
//    T update(final T entity);
//    void delete(final T entity);
//    void deleteById(final long entityId);
}
