package eu.senla.statkevich.scooters.dao;

import eu.senla.statkevich.scooters.dao.IDao.IRoleDao;
import eu.senla.statkevich.scooters.dao.IDao.IUserDao;
import eu.senla.statkevich.scooters.entity.entities.Roles;
import eu.senla.statkevich.scooters.entity.entities.Users;
import junit.framework.TestCase;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//@TestInstance(Lifecycle.PER_CLASS)
@ContextConfiguration(classes = {JPAConfig.class}, loader = AnnotationConfigContextLoader.class)
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class UserDAOTest extends TestCase {

    private Users resultUser;
    private List<Users> resultListUser;

    @Autowired
    private IUserDao userDao;
    @Autowired
    private IRoleDao roleDao;

    private Roles testRole;
    private Users testCreatedUser;

    @BeforeClass
    @Rollback(true)
    public static void prepareTestData() {
//        testRole = roleDao.readByTitle("USER");
//        testCreatedUser = userDao.create(new Users("Test", "123", "test"));
//        System.out.println(testCreatedUser);
    }

    @Test
    public void testRead() {
        Users testUser = userDao.readAll().get(0);
        resultUser = userDao.read(testUser.getId());
        //resultUser = userDao.read(testCreatedUser.getId());

        assertNotNull(resultUser);
        assertEquals(resultUser.getId(), testUser.getId());
        //assertEquals(resultUser, testCreatedUser);
    }

    @Test
    public void testReadByName() {
        Users testUser = userDao.readAll().get(0);
        resultUser = userDao.readByName(testUser.getName());
        //resultUser = userDao.readByName(testCreatedUser.getName());

        assertNotNull(resultUser);
        //assertEquals(resultUser, testCreatedUser);
        assertEquals(resultUser.getId(), testUser.getId());
    }

    @Test
    @Rollback(true)
    public void testCreate() {
        Roles role = roleDao.readByTitle("USER");
        Users testUser = new Users("Test", "123", "test");
        testUser.setRole(role);

        //Users testUser = new Users("TestCreate", "123", "test");
        //testUser.setRole(testRole);

        Users resultUser = userDao.create(testUser);

        assertNotNull(resultUser);
        assertEquals(resultUser.getName(), testUser.getName());
    }

    @Test
    public void testReadAll() {

        resultListUser = userDao.readAll();

        assertNotSame(resultListUser.size(), 0);
    }
}