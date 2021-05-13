package eu.senla.statkevich.scooters.service.IServices;

import eu.senla.statkevich.scooters.dao.PriceListDAO;
import eu.senla.statkevich.scooters.dto.PriceListDTO;
import eu.senla.statkevich.scooters.dto.ScooterDTO;
import eu.senla.statkevich.scooters.entity.PriceList;
import eu.senla.statkevich.scooters.entity.Users;

import java.util.List;

public interface PriceListService  {

    PriceListDTO readByUser(Users user);
    List<PriceListDTO> readAll();

}
