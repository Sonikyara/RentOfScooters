package eu.senla.statkevich.scooters.service;

import eu.senla.statkevich.scooters.dao.*;
import eu.senla.statkevich.scooters.dto.RentDTO;
import eu.senla.statkevich.scooters.entity.*;
import eu.senla.statkevich.scooters.service.mappers.IPriceListMapper;
import eu.senla.statkevich.scooters.service.mappers.IRentMapper;
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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RentServiceImplTest extends TestCase {


    @Mock
    private RentDAO rentDAO;
    @Mock
    private PriceListDAO priceListDAO;
    @Mock
    private UserDAO userDAO;
    @Mock
    private ScootersDAO scootersDAO;
    @Mock
    private TermOfRentDAO termOfRentDAO;

    @Spy
    IRentMapper rentMapper = Mappers.getMapper(IRentMapper.class);

    @InjectMocks
    private RentServiceImpl rentService;

    private static Rent testRent;
    private static Users testUser;
    private static Scooters testScooter;
    private static PriceList testPrice;
    private static TermOfRent testTerm;
    private static List<Rent> testListRent;
    private static RentDTO testRentDTO;

    @BeforeClass
    public static void prepareTestData() {
        testUser = new Users("Ann");
        testUser.setId(1L);

        testScooter = new Scooters();
        testScooter.setModel("Model1");

        testTerm = new TermOfRent("Day", 1);

        testPrice = new PriceList(testScooter, testTerm);

        testRent = new Rent(testUser, testScooter, testPrice);

        testListRent = new ArrayList<>();
        testListRent.add(testRent);

        testRentDTO = new RentDTO();
        testRentDTO.setDateStart("01-01-2022");
        testRentDTO.setScooter_model("Model1");
        testRentDTO.setTermOfRent("Day");

//        testListPrice = new ArrayList<>();
//        testListPrice.add(testPrice1);
//        testListPrice.add(testPrice2);
    }

    @Test
    public void testReadAll() {
        when(rentDAO.readAll()).thenReturn(testListRent);

        List<RentDTO> resultRentDTO = rentService.readAll();

        Mockito.verify(rentDAO).readAll();
        assertFalse(resultRentDTO.isEmpty());
        assertEquals(1, resultRentDTO.size());
    }

    @Test
    public void testGetByUserName() {
        when(userDAO.readByName(any(String.class))).thenReturn(testUser);
        when(rentDAO.readByUserId(any(Long.class))).thenReturn(testListRent);

        List<RentDTO> resultRentDTO = rentService.getByUserName("Ann");

        Mockito.verify(rentDAO).readByUserId(1L);
        assertFalse(resultRentDTO.isEmpty());
        assertEquals(1, resultRentDTO.size());
    }

    @Test
    public void testCreate() {
        when(userDAO.readByName(any(String.class))).thenReturn(testUser);
        when(scootersDAO.readByModel(any(String.class))).thenReturn(testScooter);
        when(termOfRentDAO.readByTitle(any(String.class))).thenReturn(testTerm);
        when(priceListDAO.readByTermAndScooter(any(Long.class), any(Long.class))).thenReturn(testPrice);
        when(rentDAO.create(any(Rent.class))).thenReturn(testRent);

        String result = rentService.create(testRentDTO);

        assertNotSame(result.length(), 0);
    }

    @Test
    public void testReturnTheScooter() {
        when(userDAO.readByName(any(String.class))).thenReturn(testUser);
        when(scootersDAO.readByModel(any(String.class))).thenReturn(testScooter);
        when(rentDAO.readByUserScooter(any(Long.class), any(Long.class))).thenReturn(testRent);
        when(rentDAO.updateDateEnd(any(Rent.class))).thenReturn(testRent);

        RentDTO resultRentDTO = rentService.returnTheScooter("Model1", "Ann");

        Mockito.verify(rentDAO).updateDateEnd(testRent);
        assertNotNull(resultRentDTO);
        assertEquals(resultRentDTO.getScooter_model(), testScooter.getModel());
    }
}