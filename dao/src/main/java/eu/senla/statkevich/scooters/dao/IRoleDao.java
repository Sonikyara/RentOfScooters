package eu.senla.statkevich.scooters.dao;

import eu.senla.statkevich.scooters.entity.Roles;

public interface IRoleDao extends IGenericDao<Roles>{

//    Roles read(final Long id);
//    Roles create(final Roles entity);

    Roles readByTitle(final String title);
}
