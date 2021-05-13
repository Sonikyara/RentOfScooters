package eu.senla.statkevich.scooters.dao;

import eu.senla.statkevich.scooters.entity.PriceList;
import eu.senla.statkevich.scooters.entity.Users;

import java.util.List;

public interface IPriceListDao {

    PriceList readByUser(Users user);

    List<PriceList> readAll();
}
