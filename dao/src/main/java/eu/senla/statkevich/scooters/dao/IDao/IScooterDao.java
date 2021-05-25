package eu.senla.statkevich.scooters.dao.IDao;

import eu.senla.statkevich.scooters.entity.Roles;
import eu.senla.statkevich.scooters.entity.Scooters;

import java.util.List;

public interface IScooterDao {

    Scooters readByModel(final String model);

    Scooters read(final Long number);

    List<Scooters> readAll();

    List<Scooters> readFree(String date);
}
