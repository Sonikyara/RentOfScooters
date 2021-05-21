package eu.senla.statkevich.scooters.service.IServices;

import java.util.List;

public interface IGenericService<T> {

    T read(final Long id);

    List<T> readAll();

}
