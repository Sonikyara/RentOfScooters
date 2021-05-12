package eu.senla.statkevich.scooters.dao;

import eu.senla.statkevich.scooters.entity.Roles;

public interface IRoleDao extends IGenericDao<Roles>{

    Roles readByTitle(final String title);
}
