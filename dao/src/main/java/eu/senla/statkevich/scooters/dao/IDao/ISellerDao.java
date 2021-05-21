package eu.senla.statkevich.scooters.dao.IDao;

import eu.senla.statkevich.scooters.entity.Sellers;

public interface ISellerDao {

    Sellers read(final Long id);
}
