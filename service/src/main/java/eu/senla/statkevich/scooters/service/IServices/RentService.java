package eu.senla.statkevich.scooters.service.IServices;

import eu.senla.statkevich.scooters.dto.RentDTO;

import java.util.List;

public interface RentService {

    String create(final RentDTO rentDTO);

    List<RentDTO> readAll();

    List<RentDTO> getByUserName(String name);

    RentDTO returnTheScooter(String scooter, String name);
}
