package eu.senla.statkevich.scooters.dao;

import eu.senla.statkevich.scooters.entity.Users;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public abstract class GenericDaoImpl<T> {
    @PersistenceContext
    protected EntityManager entityManager;

}
