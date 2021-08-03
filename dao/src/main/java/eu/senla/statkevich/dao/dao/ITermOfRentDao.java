package eu.senla.statkevich.dao.dao;

import eu.senla.statkevich.scooters.entities.TermOfRent;

public interface ITermOfRentDao {

    TermOfRent read(final Long id);

    TermOfRent readByTitle(final String title);

    //List<TermOfRent> readAll();
}
