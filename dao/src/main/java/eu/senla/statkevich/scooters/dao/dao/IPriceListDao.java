package eu.senla.statkevich.scooters.dao.dao;

import eu.senla.statkevich.scooters.entity.entities.PriceList;

import java.util.List;

public interface IPriceListDao {

    PriceList readByTermAndScooter(Long term, Long scootersNumber);

    List<PriceList> readAll();

    PriceList read(final Long id);
}
