package eu.senla.statkevich.scooters.dao;

import eu.senla.statkevich.scooters.dao.IDao.IPriceListDao;
import eu.senla.statkevich.scooters.dao.IDao.IScooterDao;
import eu.senla.statkevich.scooters.dao.IDao.ITermOfRentDao;
import eu.senla.statkevich.scooters.entity.entities.PriceList;
import eu.senla.statkevich.scooters.entity.entities.Scooters;
import eu.senla.statkevich.scooters.entity.entities.TermOfRent;
import junit.framework.TestCase;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@ContextConfiguration(classes = {JPAConfig.class}, loader = AnnotationConfigContextLoader.class)
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class PriceListDAOTest extends TestCase {

    @Autowired
    private IPriceListDao priceListDao;

    @Autowired
    private IScooterDao scooterDao;

    @Autowired
    private ITermOfRentDao termOfRentDAO;

    private static PriceList testPrice;

    @BeforeClass
    public static void prepareTestData() {
        testPrice = new PriceList();
        testPrice.setId(1L);

    }

    @Test
    public void testReadByTermAndScooter() {
        Scooters testScooter = scooterDao.readAll().get(0);
        TermOfRent termOfRent = termOfRentDAO.readByTitle("Day");

        PriceList resultPrice = priceListDao.readByTermAndScooter(termOfRent.getId(), testScooter.getNumber());

        assertNotNull(resultPrice);
        assertEquals(testScooter.getModel(), resultPrice.getScooter().getModel());
    }

    @Test
    public void testRead() {
        PriceList resultPrice = priceListDao.read(1L);

        assertNotNull(resultPrice);
        assertEquals(resultPrice.getId(), testPrice.getId());
    }

    @Test
    public void testReadAll() {
        List<PriceList> resultListPrice = priceListDao.readAll();

        assertFalse(resultListPrice.isEmpty());
        assertEquals(6, resultListPrice.size());
    }
}