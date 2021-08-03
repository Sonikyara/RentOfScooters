package eu.senla.statkevich.dao.dao;

import eu.senla.statkevich.scooters.entities.Users;

public interface IUserDao extends IGenericDao<Users> {

    Users readByName(final String name);

    Users readByPhone(String phone);
}
