package eu.senla.statkevich.scooters.dao;

import eu.senla.statkevich.scooters.dao.IDao.IPaymentDao;
import eu.senla.statkevich.scooters.dao.IDao.IPriceListDao;
import eu.senla.statkevich.scooters.dao.IDao.IRentDao;
import eu.senla.statkevich.scooters.dao.IDao.IUserDao;
import eu.senla.statkevich.scooters.entity.Payment;
import eu.senla.statkevich.scooters.entity.PriceList;
import eu.senla.statkevich.scooters.entity.Rent;
import eu.senla.statkevich.scooters.entity.Users;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@ContextConfiguration(classes = {JPAConfig.class}, loader = AnnotationConfigContextLoader.class)
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class PaymentDaoTest extends TestCase {

    @Autowired
    private IPaymentDao paymentDao;

    @Autowired
    private IUserDao userDao;

    @Autowired
    private IRentDao rentDao;

    @Autowired
    private IPriceListDao priceListDao;

    public void testCreate() {

    }

    @Test
    public void testReadAll() {
        List<Payment> listPayment = paymentDao.readAll();

        if (listPayment.size() != 0) {
            assertNotNull(listPayment.get(0));
        }
    }

    @Test
    public void testGetByUser() {
        Users resultUser = userDao.readAll().get(0);
        List<Payment> listPayment = paymentDao.getByUser(resultUser);

        if (listPayment.size() > 0) {
            assertNotNull(listPayment.get(0));
            assertEquals(listPayment.get(0).getUser().getId(), resultUser.getId());
        }
    }

    @Test
    @Rollback(true)
    public void testGetFreePayment() {
        List<Users> listUser = userDao.readAll();
        if (listUser.size() > 0) {
            Users testUser = listUser.get(0);
            PriceList testPriceList = priceListDao.readAll().get(0);

            List<Payment> resultListPayment = paymentDao.getFreePayment(testUser, testPriceList.getPrice());
            if (resultListPayment.size() > 0) {
                Payment testPayment = resultListPayment.get(0);
                assertNotNull(testPayment);
                assertEquals(testPayment.getUser(), testUser);
                assertEquals(testPayment.getSum(), testPriceList.getPrice());
            }
        }
    }

    @Test
    @Rollback(true)
    public void testUpdateRentId() {
        List<Rent> listRent = rentDao.readAll();

        if (listRent.size() > 0) {
            Rent testRent = listRent.get(0);

            List<Payment> listPayment = paymentDao.getFreePayment(testRent.getUser(), testRent.getPrice().getPrice());
            if (listPayment.size() > 0) {
                Payment testPayment = listPayment.get(0);
                testPayment.setRent(testRent);

                Payment resultPayment = paymentDao.updateRentId(testPayment);

                assertNotNull(resultPayment);
                assertEquals(resultPayment.getRent(), testPayment.getRent());
            }
        }

    }
}