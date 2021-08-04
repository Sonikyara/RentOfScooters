package eu.senla.statkevich.scooters.dao.dao;

import eu.senla.statkevich.scooters.entity.entities.TypesProducers;

public interface ITypeProducerDao {

    TypesProducers read(final Long id);
}
