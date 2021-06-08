package eu.senla.statkevich.scooters.dao.implementations;

import eu.senla.statkevich.scooters.dao.dao.ITypeProducerDao;
import eu.senla.statkevich.scooters.entity.entities.TypesProducers;
import org.springframework.stereotype.Repository;

@Repository
public class TypeProducerDAO extends GenericDaoImpl<TypesProducers> implements ITypeProducerDao {

    @Override
    public TypesProducers read(final Long id) {
        return entityManager.find(TypesProducers.class, id);
    }
}

