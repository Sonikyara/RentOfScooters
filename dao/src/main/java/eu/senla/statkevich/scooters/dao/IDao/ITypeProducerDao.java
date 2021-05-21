package eu.senla.statkevich.scooters.dao.IDao;

import eu.senla.statkevich.scooters.entity.TypesProducers;

public interface ITypeProducerDao {

    TypesProducers read(final Long id);
}
