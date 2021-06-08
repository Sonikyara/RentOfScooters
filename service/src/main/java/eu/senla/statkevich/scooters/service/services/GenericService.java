package eu.senla.statkevich.scooters.service.services;

import java.util.List;

public interface GenericService<T> {

    T read(final Long id);

    List<T> readAll();

}
