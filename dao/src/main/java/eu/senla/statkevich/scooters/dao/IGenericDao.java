package eu.senla.statkevich.scooters.dao;

import java.io.Serializable;
import java.util.List;

public interface IGenericDao<T>  {
    T read(final long id);

    void create(final T entity);

//    List<T> readAll();
//
//    T update(final T entity);
//
//    void delete(final T entity);
//
//    void deleteById(final long entityId);
}
