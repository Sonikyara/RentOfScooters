package eu.senla.statkevich.dao.dao;

import eu.senla.statkevich.scooters.entities.Sellers;

public interface ISellerDao {

    Sellers read(final Long id);
}
