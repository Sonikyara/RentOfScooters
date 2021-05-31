package eu.senla.statkevich.scooters.service.ServicesI;

import eu.senla.statkevich.scooters.dto.RoleDTO;

public interface RolesService {
    RoleDTO readByTitle(final String title);

    RoleDTO read(final Long id);

}
