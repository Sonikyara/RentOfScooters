package eu.senla.statkevich.scooters.dao;

import eu.senla.statkevich.scooters.entity.TermOfRent;

import java.util.List;

public interface ITermOfRentDAO {

    TermOfRent read(final Long id);

    TermOfRent readByTitle(final String title);

    List<TermOfRent> readAll();
}
