package eu.senla.statkevich.scooters.dao.implementations;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class GenericDaoImpl<T> {
    @PersistenceContext
    protected EntityManager entityManager;

}
