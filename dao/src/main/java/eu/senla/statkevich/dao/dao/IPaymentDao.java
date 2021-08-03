package eu.senla.statkevich.dao.dao;

import eu.senla.statkevich.scooters.entities.Payment;
import eu.senla.statkevich.scooters.entities.Rent;
import eu.senla.statkevich.scooters.entities.Users;

import java.math.BigDecimal;
import java.util.List;

public interface IPaymentDao {

    Payment create(Payment payment);

    List<Payment> readAll();

    List<Payment> readPage(int firstResult, int sizeOfPage, Users user, BigDecimal sum);

    List<Payment> getByUser(Users user);

    List<Payment> getFreePayment(Users user, BigDecimal sum);

    Payment updateRentId(Payment payment, Rent rent);
}
