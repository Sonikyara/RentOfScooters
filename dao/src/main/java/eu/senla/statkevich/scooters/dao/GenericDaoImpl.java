package eu.senla.statkevich.scooters.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class GenericDaoImpl<T> implements IGenericDao<T>{
    @PersistenceContext
    protected EntityManager entityManager;

}
