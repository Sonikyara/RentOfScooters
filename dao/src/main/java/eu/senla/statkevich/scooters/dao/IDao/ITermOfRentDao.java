package eu.senla.statkevich.scooters.dao.IDao;

import eu.senla.statkevich.scooters.entity.entities.TermOfRent;

import java.util.List;

public interface ITermOfRentDao {

    TermOfRent read(final Long id);

    TermOfRent readByTitle(final String title);

    List<TermOfRent> readAll();
}
