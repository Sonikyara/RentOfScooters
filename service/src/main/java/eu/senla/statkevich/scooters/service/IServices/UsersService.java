package eu.senla.statkevich.scooters.service.IServices;

import eu.senla.statkevich.scooters.dto.UserDTO;
import eu.senla.statkevich.scooters.service.IServices.IGenericService;

public interface UsersService  extends IGenericService<UserDTO> {

    UserDTO readByName(final String name);
    String create(UserDTO userDTO);

    //
//    T update(final T entity);
//
//    void delete(final T entity);
//
//    void deleteById(final long entityId);
}
