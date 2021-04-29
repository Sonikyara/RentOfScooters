package eu.senla.statkevich.scooters.service;

import eu.senla.statkevich.scooters.dto.UserDTO;
import eu.senla.statkevich.scooters.entity.Users;

public interface UsersService  {
    UserDTO read(final Long id);

    Users create(UserDTO userDTO);

//    List<T> readAll();
//
//    T update(final T entity);
//
//    void delete(final T entity);
//
//    void deleteById(final long entityId);
}
