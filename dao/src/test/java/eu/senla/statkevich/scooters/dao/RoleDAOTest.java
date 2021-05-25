package eu.senla.statkevich.scooters.dao;

import eu.senla.statkevich.scooters.dao.IDao.IRoleDao;
import eu.senla.statkevich.scooters.entity.Roles;
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
public class RoleDAOTest extends TestCase {

    @Autowired
    private IRoleDao roleDAO;

    private static Roles testRole;

    @BeforeClass
    public static void prepareTestData() {
        System.out.println("prepareTestData");
        testRole = new Roles("USER");
    }

    //@Rollback(true)
    @Test
    public void testReadByTitle() {
        System.out.println("DAO-TestReadByTitle");

        Roles resultRole = roleDAO.readByTitle("USER");
        System.out.println("resultRole - " + resultRole.toString());

        assertNotNull(resultRole);
        assertEquals(resultRole.getTitle(), testRole.getTitle());

    }
}

//    @PersistenceContext
//    protected EntityManager entityManager;
//System.out.println("entityManager - "+entityManager);

//System.out.println("DAO-result role - "+resultRole.toString());
//assertEquals(1, resultRole.size());