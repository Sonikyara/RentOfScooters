package eu.senla.statkevich.scooters.service.IServices;

import eu.senla.statkevich.scooters.dto.ScooterDTO;

import java.util.Date;
import java.util.List;

public interface ScootersService extends IGenericService<ScooterDTO> {

    ScooterDTO readByModel(final String model);

    List<ScooterDTO> readFreeScooters(String date);
}
