package eu.senla.statkevich.scooters.service.ServicesI;

import eu.senla.statkevich.scooters.dto.ScooterDTO;

import java.time.LocalDate;
import java.util.List;

public interface ScootersService extends GenericService<ScooterDTO> {

    ScooterDTO readByModel(final String model);

    List<ScooterDTO> readFreeScooters(LocalDate date);
}
