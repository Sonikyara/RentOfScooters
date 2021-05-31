package eu.senla.statkevich.scooters.dao.DAO;

import eu.senla.statkevich.scooters.dao.IDao.ISellerDao;
import eu.senla.statkevich.scooters.entity.entities.Sellers;
import org.springframework.stereotype.Repository;

@Repository
public class SellerDAO extends GenericDaoImpl<Sellers> implements ISellerDao {

    @Override
    public Sellers read(final Long id) {
        return entityManager.find(Sellers.class, id);
    }
}

