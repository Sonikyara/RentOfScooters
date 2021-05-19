package eu.senla.statkevich.scooters.dao;

import eu.senla.statkevich.scooters.entity.Rent;
import eu.senla.statkevich.scooters.entity.Users;

import java.util.List;

public interface IRentDao {

    List<Rent> readByUserId(Long id);

    List<Rent> readAll();

    Rent create(final Rent rent);
}
