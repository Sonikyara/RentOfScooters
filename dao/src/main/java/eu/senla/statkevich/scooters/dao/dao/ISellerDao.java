package eu.senla.statkevich.scooters.dao.dao;

import eu.senla.statkevich.scooters.entity.entities.Sellers;

public interface ISellerDao {

    Sellers read(final Long id);
}
