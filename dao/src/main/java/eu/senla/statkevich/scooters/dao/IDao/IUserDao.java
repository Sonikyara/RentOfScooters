package eu.senla.statkevich.scooters.dao.IDao;

import eu.senla.statkevich.scooters.entity.entities.Users;

public interface IUserDao extends IGenericDao<Users> {

//    Users read(final Long id);
//    Users create(final Users entity);

    Users readByName(final String name);

}
