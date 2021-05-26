package eu.senla.statkevich.scooters.dao;

import eu.senla.statkevich.scooters.dao.IDao.*;
import eu.senla.statkevich.scooters.entity.*;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@ContextConfiguration(classes = {JPAConfig.class}, loader = AnnotationConfigContextLoader.class)
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class RentDAOTest extends TestCase {

    @Autowired
    private IRentDao rentDao;

    @Autowired
    private IScooterDao scooterDao;

    @Autowired
    private IUserDao userDao;

    @Autowired
    private ITermOfRentDAO termOfRentDAO;

    @Autowired
    private IPriceListDao priceListDao;

    @Test
    public void testReadByUserId() {
        Users resultUser = userDao.readAll().get(0);
        List<Rent> listRent = rentDao.readByUserId(resultUser.getId());

        assertNotSame(listRent.size(), 0);
    }

    @Test
    public void testReadByUserScooter() {
        Scooters testScooter = scooterDao.readAll().get(0);
        Users testUser = userDao.readAll().get(0);

        Rent resultRent = rentDao.readByUserScooter(testUser.getId(), testScooter.getNumber());

        assertNotNull(resultRent);
        assertEquals(resultRent.getUser().getId(), testUser.getId());
    }

    @Test
    @Rollback(true)
    public void testUpdateDateEnd() {
        Rent testRent = rentDao.readAll().get(0);
        //System.out.println(testRent);
        try {
            testRent.setDateEnd((new SimpleDateFormat("dd-MM-yy")).parse("01-01-2022"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Rent resultRent=rentDao.updateDateEnd(testRent);

        //System.out.println(resultRent);

        assertEquals(resultRent.getDateEnd(), testRent.getDateEnd());
        assertEquals(resultRent.getUser(), testRent.getUser());
        assertEquals(resultRent.getScooter(), testRent.getScooter());
    }

    @Test
    public void testReadAll() {
        List<Rent> listRent = rentDao.readAll();

        assertNotSame(listRent.size(), 0);
    }

    @Test
    @Rollback(true)
    public void testCreate() {

        Users user = userDao.readAll().get(0);
        Scooters scooter = scooterDao.readAll().get(0);
        TermOfRent termOfRent = termOfRentDAO.readByTitle("Day");
        PriceList priceList = priceListDao.readByTermAndScooter(termOfRent.getId(), scooter.getNumber());


        Rent testRent = new Rent(user, scooter, priceList);
        try {
            testRent.setDateStart((new SimpleDateFormat("dd-MM-yy")).parse("01-01-2022"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Rent resultRent = rentDao.create(testRent);

        assertNotNull(resultRent);
        assertEquals(resultRent.getDateStart(), testRent.getDateStart());
        assertEquals(resultRent.getUser(), testRent.getUser());
        assertEquals(resultRent.getScooter(), testRent.getScooter());

    }
}