package eu.senla.statkevich.scooters.dao;

import java.util.List;

public interface IGenericDao<T>  {

    T read(final Long id);

    T create(final T entity);

    List<T> readAll();

//    T update(final T entity);
//    void delete(final T entity);
//    void deleteById(final long entityId);
}
