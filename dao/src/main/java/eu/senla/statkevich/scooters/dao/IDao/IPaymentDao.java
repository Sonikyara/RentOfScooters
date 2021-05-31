package eu.senla.statkevich.scooters.dao.IDao;

import eu.senla.statkevich.scooters.entity.entities.Payment;
import eu.senla.statkevich.scooters.entity.entities.Users;

import java.math.BigDecimal;
import java.util.List;

public interface IPaymentDao {

    Payment create(Payment payment);

    List<Payment> readAll();

    List<Payment> getByUser(Users user);

    List<Payment> getFreePayment(Users user, BigDecimal sum);

    Payment  updateRentId(Payment payment);
}
