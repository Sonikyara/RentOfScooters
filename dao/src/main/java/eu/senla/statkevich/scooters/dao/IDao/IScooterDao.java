package eu.senla.statkevich.scooters.dao.IDao;

import eu.senla.statkevich.scooters.entity.Scooters;

import java.util.Date;
import java.util.List;

public interface IScooterDao {

    Scooters readByModel(final String model);

    Scooters read(final Long number);

    List<Scooters> readAll();

    List<Object[]> readFree(String date);
}
