package eu.senla.statkevich.dao.dao;

import eu.senla.statkevich.scooters.entities.PriceList;

import java.util.List;

public interface IPriceListDao {

    PriceList readByTermAndScooter(Long term, Long scootersNumber);

    List<PriceList> readAll();

    PriceList read(final Long id);
}
