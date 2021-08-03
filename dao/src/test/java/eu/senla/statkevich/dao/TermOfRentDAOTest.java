package eu.senla.statkevich.dao;

import eu.senla.statkevich.dao.dao.ITermOfRentDao;
import eu.senla.statkevich.scooters.entities.TermOfRent;
import junit.framework.TestCase;
import org.junit.BeforeClass;
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
    private ITermOfRentDao termOfRentDAO;

    private static TermOfRent testTerm;
    private static Long testId;

    @BeforeClass
    public static void prepareTestData() {
        testTerm = new TermOfRent("Day", 1);
        testId= Long.valueOf(1);
    }

    @Test
    public void testReadByTitle() {
        TermOfRent resultTermOfRent = termOfRentDAO.readByTitle(testTerm.getTitle());

        assertNotNull(resultTermOfRent);
        assertEquals(testTerm.getTitle(), resultTermOfRent.getTitle());
    }

    @Test
    public void testRead() {
        TermOfRent resultTermOfRent = termOfRentDAO.read(1L);

        assertNotNull(resultTermOfRent);
        assertEquals(testId, resultTermOfRent.getId());
    }
}