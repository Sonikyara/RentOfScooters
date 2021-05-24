package eu.senla.statkevich.scooters.dao;

import eu.senla.statkevich.scooters.entity.Roles;
import junit.framework.TestCase;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import java.util.List;

@ContextConfiguration(classes = JPAConfig.class)
@RunWith(MockitoJUnitRunner.class)
@Transactional
public class RoleDAOTest extends TestCase {

    @PersistenceContext
    protected EntityManager entityManager;

    private static Roles testRole;

    @BeforeClass
    public static void prepareTestData() {
        System.out.println("prepareTestData");
        testRole=new Roles("USER");
    }

    //@Rollback(true)
    @Test
    public void testReadByTitle() {
        System.out.println("DAO-TestReadByTitle");
        System.out.println("entityManager - "+entityManager);

        Query query = entityManager.createNativeQuery("SELECT * FROM roles WHERE title=?1", Roles.class);
        query.setParameter(1, "USER");
        List<Roles> resultRole= query.getResultList();

        System.out.println("DAO-result role - "+resultRole.get(0).toString());

        assertEquals(1, resultRole.size());
        assertEquals(resultRole.get(0).getTitle(), testRole.getTitle());

    }


}