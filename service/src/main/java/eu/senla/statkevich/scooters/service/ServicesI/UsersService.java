package eu.senla.statkevich.scooters.service.ServicesI;

import eu.senla.statkevich.scooters.dto.UserDTO;
import eu.senla.statkevich.scooters.entity.entities.Users;

public interface UsersService extends GenericService<UserDTO> {

    UserDTO readByName(final String name);

    UserDTO create(UserDTO userDTO);

}
