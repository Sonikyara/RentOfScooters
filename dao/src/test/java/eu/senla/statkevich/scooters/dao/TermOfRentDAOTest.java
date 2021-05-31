package eu.senla.statkevich.scooters.dao;

import eu.senla.statkevich.scooters.dao.IDao.ITermOfRentDAO;
import eu.senla.statkevich.scooters.entity.entities.TermOfRent;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

@ContextConfiguration(classes = {JPAConfig.class}, loader = AnnotationConfigContextLoader.class)
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class TermOfRentDAOTest extends TestCase {

    @Autowired
    private ITermOfRentDAO termOfRentDAO;

    @Test
    public void testReadByTitle() {
        TermOfRent resultTermOfRent = termOfRentDAO.readByTitle("Day");

        assertNotNull(resultTermOfRent);
    }

    @Test
    public void testRead() {
        TermOfRent resultTermOfRent = termOfRentDAO.read(1L);

        assertNotNull(resultTermOfRent);
    }
}