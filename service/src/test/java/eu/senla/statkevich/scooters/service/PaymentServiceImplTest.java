package eu.senla.statkevich.scooters.service;

import eu.senla.statkevich.scooters.dao.PaymentDao;
import eu.senla.statkevich.scooters.dao.UserDAO;
import eu.senla.statkevich.scooters.dto.PaymentDTO;
import eu.senla.statkevich.scooters.entity.entities.Payment;
import eu.senla.statkevich.scooters.entity.entities.Users;
import eu.senla.statkevich.scooters.service.mappers.IPaymentMapper;
import junit.framework.TestCase;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PaymentServiceImplTest extends TestCase {

    @Mock
    private PaymentDao paymentDao;

    @Spy
    IPaymentMapper paymentMapper = Mappers.getMapper(IPaymentMapper.class);

    @Mock
    private UserDAO userDao;

    @InjectMocks
    private PaymentServiceImpl paymentService;

    private static Users testUser;
    private static Payment testPayment;
    private static List<Payment> testListPayment;

    @BeforeClass
    public static void prepareTestData() {
        testUser = new Users("Ann");
        testUser.setId(1L);

        testPayment = new Payment(new BigDecimal(7), testUser);

        testListPayment = new ArrayList<>();
        testListPayment.add(testPayment);

    }

    @Test
    public void testCreate() {
        when(userDao.readByName(any(String.class))).thenReturn(testUser);
        when(paymentDao.create(any(Payment.class))).thenReturn(testPayment);

        PaymentDTO testPaymentDTO = paymentMapper.paymentToPaymentDTO(testPayment);
        PaymentDTO resultPaymentDTO = paymentService.create(testPayment.getSum(), testUser.getName());

        assertNotNull(resultPaymentDTO);
        assertEquals(testPaymentDTO.getUserName(), resultPaymentDTO.getUserName());
    }

    @Test
    public void testReadAll() {
        when(paymentDao.readAll()).thenReturn(testListPayment);

        List<PaymentDTO> resultListPaymentDTO = paymentService.readAll();

        Mockito.verify(paymentDao).readAll();
        assertFalse(resultListPaymentDTO.isEmpty());
        assertEquals(1, resultListPaymentDTO.size());
    }

    @Test
    public void testGetByUserName() {
        when(userDao.readByName(any(String.class))).thenReturn(testUser);
        when(paymentDao.getByUser(any(Users.class))).thenReturn(testListPayment);

        List<PaymentDTO> resultListPaymentDTO = paymentService.getByUserName(testUser.getName());

        Mockito.verify(paymentDao).getByUser(testUser);
        assertFalse(resultListPaymentDTO.isEmpty());
        assertEquals(1, resultListPaymentDTO.size());
    }
}