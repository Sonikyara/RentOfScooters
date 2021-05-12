package eu.senla.statkevich.scooters.service.IServices;

import eu.senla.statkevich.scooters.dto.ScooterDTO;

public interface ScootersService extends IGenericService<ScooterDTO> {

    ScooterDTO readByModel(final String model);

}
