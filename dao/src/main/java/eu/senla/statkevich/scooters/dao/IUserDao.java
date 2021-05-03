package eu.senla.statkevich.scooters.dao;

import eu.senla.statkevich.scooters.entity.Roles;
import eu.senla.statkevich.scooters.entity.Users;

public interface IUserDao {

    Users read(final Long id);

    Users create(final Users entity);

    Users readByName(final String name);

}
