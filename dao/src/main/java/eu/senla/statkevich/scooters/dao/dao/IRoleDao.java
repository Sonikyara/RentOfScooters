package eu.senla.statkevich.scooters.dao.dao;

import eu.senla.statkevich.scooters.entity.entities.Roles;

public interface IRoleDao extends IGenericDao<Roles> {

    Roles readByTitle(final String title);
}
