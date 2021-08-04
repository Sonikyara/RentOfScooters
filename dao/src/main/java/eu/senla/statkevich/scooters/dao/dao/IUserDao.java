package eu.senla.statkevich.scooters.dao.dao;

import eu.senla.statkevich.scooters.entity.entities.Users;

public interface IUserDao extends IGenericDao<Users> {

    Users readByName(final String name);

    Users readByPhone(String phone);
}
