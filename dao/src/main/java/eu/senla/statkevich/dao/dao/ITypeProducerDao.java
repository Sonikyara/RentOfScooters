package eu.senla.statkevich.dao.dao;

import eu.senla.statkevich.scooters.entities.TypesProducers;

public interface ITypeProducerDao {

    TypesProducers read(final Long id);
}
