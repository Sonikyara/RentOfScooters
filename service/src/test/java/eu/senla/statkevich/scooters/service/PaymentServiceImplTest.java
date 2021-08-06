package eu.senla.statkevich.scooters.service;

import eu.senla.statkevich.scooters.dao.implementations.PaymentDAO;
import eu.senla.statkevich.scooters.dao.implementations.UserDAO;
import eu.senla.statkevich.scooters.dto.PaymentDTO;
import eu.senla.statkevich.scooters.entity.entities.Payment;
import eu.senla.statkevich.scooters.entity.entities.Users;
import eu.senla.statkevich.scooters.service.mappers.IPaymentMapper;
import eu.senla.statkevich.scooters.service.implementations.PaymentServiceImpl;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.test.context.ContextConfiguration;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

//@JsonTest  //---???
//@DataJpaTest  //---???нужно ли
//@DataJpaTest;
//@RestClientTest

@RunWith(MockitoJUnitRunner.class)

//@ContextConfiguration(classes = PaymentServiceImplTestConfig.class)
@SpringBootTest
//@AutoConfigureMockMvc

//@WebMvcTest  --- Для тестирования контроллеров без использования полноценного сервера
//@WebFluxTest --- втоматически настраивает инфраструктуру модуля Spring WebFlux и ищет только Controller, ControllerAdvice, @JsonComponent, Converter, GenericConverter и WebFluxConfigurer.
public class PaymentServiceImplTest extends TestCase {

    @TestConfiguration
    //@ComponentScan(basePackages = "eu.senla.statkevich.scooters.service")
    //@ComponentScan(basePackages = {
    //        "eu.senla.statkevich.scooters.controller",
    //        "eu.senla.statkevich.scooters.dao",
    //        "eu.senla.statkevich.scooters.service"
    //        ,
    //        "eu.senla.statkevich.scooters.dao"
    //        ,"eu.senla.statkevich.scooters.entity"
    //})
    public static class ServiceImplTestConfig {

    }

    @Mock
    //@MockBean
    private PaymentDAO paymentDao;

    @Spy
    IPaymentMapper paymentMapper = Mappers.getMapper(IPaymentMapper.class);

    @Mock
    private UserDAO userDao;

    @InjectMocks
    private PaymentServiceImpl paymentService;

    private static Users testUser;
    private static Long testUsersId;
    private static Payment testPayment;
    private static List<Payment> testListPayment;

    private static BigDecimal sum;

    @BeforeClass
    public static void prepareTestData() {
        testUser = new Users("Ann");
        testUsersId= 1L;

        testPayment = new Payment(new BigDecimal(7), testUser);

        testListPayment = new ArrayList<>();
        testListPayment.add(testPayment);

        sum = BigDecimal.valueOf(7);
    }

    @Test
    public void testCreate() {
        when(userDao.readByName(any(String.class))).thenReturn(testUser);
        when(paymentDao.create(any(Payment.class))).thenReturn(testPayment);

        PaymentDTO testPaymentDTO = paymentMapper.paymentToPaymentDTO(testPayment);
        PaymentDTO resultPaymentDTO = paymentService.create(testPayment.getSum(), testUser.getName());

        verify(userDao, Mockito.atLeast(1)).readByName(testUser.getName());
        verify(paymentDao).create(any(Payment.class));
        assertNotNull(resultPaymentDTO);
        assertEquals(testPaymentDTO.getUserName(), resultPaymentDTO.getUserName());
    }

    @Test
    public void testReadAll() {
        when(paymentDao.readAll()).thenReturn(testListPayment);

        List<PaymentDTO> resultListPaymentDTO = paymentService.readAll();

        verify(paymentDao).readAll();
        assertFalse(resultListPaymentDTO.isEmpty());
        assertEquals(1, resultListPaymentDTO.size());
    }

    @Test
    public void testGetByUserName() {
        when(userDao.readByName(any(String.class))).thenReturn(testUser);
        when(paymentDao.getByUser(any(Users.class))).thenReturn(testListPayment);

        List<PaymentDTO> resultListPaymentDTO = paymentService.getByUserName(testUser.getName());

        verify(userDao, Mockito.atLeast(1)).readByName(testUser.getName());
        verify(paymentDao).getByUser(testUser);
        assertFalse(resultListPaymentDTO.isEmpty());
        assertEquals(1, resultListPaymentDTO.size());
    }

    @Test
    public void testReadPage() {
        when(userDao.readByName(any(String.class))).thenReturn(testUser);
        when(paymentDao.readPage(any(Integer.class), any(Integer.class), any(Users.class), any(BigDecimal.class))).thenReturn(testListPayment);

        List<PaymentDTO> resultListPaymentDTO = paymentService.readPage(1, 1, testUser.getName(), sum);

        verify(userDao, Mockito.atLeast(1)).readByName(testUser.getName());
        verify(paymentDao).readPage(0, 1, testUser, sum);

        if (!resultListPaymentDTO.isEmpty()) {
            assertEquals(resultListPaymentDTO.get(0).getUserName(), testUser.getName());
            assertEquals(resultListPaymentDTO.get(0).getSum(), sum);
        }

    }
}