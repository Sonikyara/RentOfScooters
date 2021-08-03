package eu.senla.statkevich.dao.implementations;

import eu.senla.statkevich.dao.dao.ISellerDao;
import eu.senla.statkevich.scooters.entities.Sellers;
import org.springframework.stereotype.Repository;

@Repository
public class SellerDAO extends GenericDaoImpl<Sellers> implements ISellerDao {

    @Override
    public Sellers read(final Long id) {
        return entityManager.find(Sellers.class, id);
    }
}

