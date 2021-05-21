package eu.senla.statkevich.scooters.service.IServices;

import eu.senla.statkevich.scooters.dto.PriceListDTO;
import eu.senla.statkevich.scooters.dto.RentDTO;
import eu.senla.statkevich.scooters.dto.RoleDTO;
import eu.senla.statkevich.scooters.entity.Users;

import java.util.List;

public interface RentService {

    RentDTO readByUser(Users user);

    String create(final RentDTO rentDTO);

    List<RentDTO> readAll();

    List<RentDTO> getByUserName(String name);

    RentDTO returnTheScooter(String scooter, String name);
}
