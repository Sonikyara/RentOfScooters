package eu.senla.statkevich.scooters.dao.IDao;

import eu.senla.statkevich.scooters.entity.entities.Rent;

import java.util.List;

public interface IRentDao {

    List<Rent> readByUserId(Long id);

    List<Rent> readAll();

    Rent create(final Rent rent);

    Rent updateDateEnd(Rent rent);

    Rent readByUserScooter(Long id, Long number);
}
