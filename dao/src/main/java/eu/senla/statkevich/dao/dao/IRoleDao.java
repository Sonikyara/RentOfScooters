package eu.senla.statkevich.dao.dao;

import eu.senla.statkevich.scooters.entities.Roles;

public interface IRoleDao extends IGenericDao<Roles> {

    Roles readByTitle(final String title);
}
