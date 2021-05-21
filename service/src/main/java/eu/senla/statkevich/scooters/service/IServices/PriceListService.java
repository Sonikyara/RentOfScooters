package eu.senla.statkevich.scooters.service.IServices;

import eu.senla.statkevich.scooters.dto.PriceListDTO;
import eu.senla.statkevich.scooters.entity.Users;

import java.util.List;

public interface PriceListService {

    PriceListDTO readByUser(Users user);

    PriceListDTO readByTermIdAndScooter(Long term, String scootersModel);

    PriceListDTO readByTermAndScooter(String term, String scootersModel);

    List<PriceListDTO> readAll();

}
