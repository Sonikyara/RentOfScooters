package eu.senla.statkevich.scooters.service.services;

import eu.senla.statkevich.scooters.dto.UserDTO;

public interface UsersService extends GenericService<UserDTO> {

    UserDTO readByName(final String name);

    UserDTO create(UserDTO userDTO);

}
