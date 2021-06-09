package eu.senla.statkevich.scooters.service.implementations;

import eu.senla.statkevich.scooters.dao.dao.IPaymentDao;
import eu.senla.statkevich.scooters.dao.dao.IUserDao;
import eu.senla.statkevich.scooters.dto.PaymentDTO;
import eu.senla.statkevich.scooters.entity.entities.Payment;
import eu.senla.statkevich.scooters.entity.entities.Users;
import eu.senla.statkevich.scooters.service.services.PaymentService;
import eu.senla.statkevich.scooters.service.mappers.IPaymentMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {

    private static final Logger logger = Logger.getLogger(PaymentServiceImpl.class);

    @Autowired
    private IPaymentDao paymentDao;

    @Autowired
    private IPaymentMapper paymentMapper;

    @Autowired
    private IUserDao userDao;

    @Override
    public PaymentDTO create(BigDecimal sum, String userName) {
        Payment payment = new Payment(sum, userDao.readByName(userName));
        return paymentMapper.paymentToPaymentDTO(paymentDao.create(payment));
    }

    @Override
    public List<PaymentDTO> readAll() {
        return paymentMapper.listPaymentToListPaymentDto(paymentDao.readAll());
    }

    @Override
    public List<PaymentDTO> readPage(int page, int sizeOfPage, String userName, BigDecimal sum) {
        int firstResult = (page - 1) * sizeOfPage;

        Users user = Optional.ofNullable(userName).map(userDao::readByName).orElse(null);

        return paymentMapper.listPaymentToListPaymentDto(paymentDao.readPage(firstResult, sizeOfPage, user, sum));
    }

    @Override
    public List<PaymentDTO> getByUserName(String name) {
        return paymentMapper.listPaymentToListPaymentDto(paymentDao.getByUser(userDao.readByName(name)));
    }
}
