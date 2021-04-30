package eu.senla.statkevich.scooters.service;

import eu.senla.statkevich.scooters.dto.RoleDTO;
import eu.senla.statkevich.scooters.dto.UserDTO;
import eu.senla.statkevich.scooters.entity.Roles;
import eu.senla.statkevich.scooters.entity.Users;

public interface RolesService {
    //RoleDTO readByTitle(final String title);
    RoleDTO readByTitle(final String title);

    RoleDTO read(final Long id);

    Roles create(String title);

}
