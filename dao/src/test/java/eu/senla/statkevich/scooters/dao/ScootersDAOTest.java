package eu.senla.statkevich.scooters.dao;

import eu.senla.statkevich.scooters.dao.IDao.IScooterDao;
import eu.senla.statkevich.scooters.entity.entities.Scooters;
import junit.framework.TestCase;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@ContextConfiguration(classes = {JPAConfig.class}, loader = AnnotationConfigContextLoader.class)
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class ScootersDAOTest extends TestCase {

    @Autowired
    private IScooterDao scooterDao;

    private static Long testScootersNumber;
    private static String testScootersModel;
    private static String testDateForFree;

    @BeforeClass
    public static void prepareTestData() {
        testScootersNumber = Long.valueOf(1);
        testScootersModel = "Model1";
        testDateForFree="2020-07-01";
    }

    @Test
    public void testRead() {
        Scooters resultScooter = scooterDao.read(testScootersNumber);

        assertNotNull(resultScooter);
        assertEquals(resultScooter.getNumber(), testScootersNumber);
    }

    @Test
    public void testReadByModel() {
        Scooters resultScooter = scooterDao.readByModel(testScootersModel);

        assertNotNull(resultScooter);
        assertEquals(resultScooter.getModel(), testScootersModel);
    }

    @Test
    public void testReadAll() {
        List<Scooters> listScooters = scooterDao.readAll();

        assertNotSame(listScooters.size(), 0);
    }

    @Test
    public void testReadFree() {
        List<Scooters> listScooters = scooterDao.readFree(testDateForFree);

        if (listScooters.size() > 0) {
            assertNotNull(listScooters.get(0));
        }
    }
}