package eu.senla.statkevich.scooters.service;

import eu.senla.statkevich.scooters.dao.IDao.IPaymentDao;
import eu.senla.statkevich.scooters.dao.IDao.IPriceListDao;
import eu.senla.statkevich.scooters.dao.IDao.IUserDao;
import eu.senla.statkevich.scooters.dto.PaymentDTO;
import eu.senla.statkevich.scooters.entity.Payment;
import eu.senla.statkevich.scooters.service.IServices.PaymentService;
import eu.senla.statkevich.scooters.service.mappers.IPaymentMapper;
import eu.senla.statkevich.scooters.service.mappers.IPriceListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private IPaymentDao paymentDao;

    @Autowired
    private IPaymentMapper paymentMapper;

    @Autowired
    private IUserDao userDao;

    @Override
    public PaymentDTO create(BigDecimal sum,String userName) {
        Payment payment=new Payment(sum, userDao.readByName(userName));
        return paymentMapper.paymentToPaymentDTO(paymentDao.create(payment));
    }

    @Override
    public List<PaymentDTO> readAll() {
        return paymentMapper.listPaymentToListPaymentDto(paymentDao.readAll());
    }

    @Override
    public List<PaymentDTO> getByUserName(String name) {

        return paymentMapper.listPaymentToListPaymentDto(paymentDao.getByUser(userDao.readByName(name)));
    }
}
