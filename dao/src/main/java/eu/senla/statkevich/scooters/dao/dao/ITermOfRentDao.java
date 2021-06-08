package eu.senla.statkevich.scooters.dao.dao;

import eu.senla.statkevich.scooters.entity.entities.TermOfRent;

public interface ITermOfRentDao {

    TermOfRent read(final Long id);

    TermOfRent readByTitle(final String title);

    //List<TermOfRent> readAll();
}
