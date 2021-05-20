package eu.senla.statkevich.scooters.dao.IDao;

import eu.senla.statkevich.scooters.entity.PriceList;
import eu.senla.statkevich.scooters.entity.Scooters;
import eu.senla.statkevich.scooters.entity.TermOfRent;
import eu.senla.statkevich.scooters.entity.Users;

import java.util.List;

public interface IPriceListDao {

    PriceList readByTermAndScooter(Long term, Long scootersNumber);

    List<PriceList> readAll();

    PriceList read(final Long id);
}
