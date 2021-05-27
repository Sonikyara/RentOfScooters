package eu.senla.statkevich.scooters.service.IServices;

import eu.senla.statkevich.scooters.dto.PaymentDTO;

import java.math.BigDecimal;
import java.util.List;

public interface PaymentService {

    PaymentDTO create(final BigDecimal sum,String userName);

    List<PaymentDTO> readAll();

    List<PaymentDTO> getByUserName(String name);

}
