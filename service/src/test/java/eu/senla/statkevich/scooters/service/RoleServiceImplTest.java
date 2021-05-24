package eu.senla.statkevich.scooters.service;

import eu.senla.statkevich.scooters.dao.RoleDAO;
import eu.senla.statkevich.scooters.entity.Roles;
import junit.framework.TestCase;
import org.junit.BeforeClass;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;


import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RoleServiceImplTest extends TestCase {

    @Mock
    private RoleDAO roleDAO;

    private static Roles testRole;

//    @Autowired
//    private IRoleMapper roleMapper;

    @BeforeClass
    public static void prepareTestData() {
        System.out.println("prepareTestData");
        testRole=new Roles("TestUser");
        testRole.setId(10L);
    }

    @Test
    public void testRead() {
        System.out.println("TestRead");
        when(roleDAO.read(any(Long.class))).thenReturn(testRole);

        Roles resultRole=roleDAO.read(10L);

        assertNotNull(resultRole);
        assertSame(resultRole.getId(),resultRole.getId());
        assertEquals(testRole,resultRole);
    }

    @Test
    public void testReadByTitle() {
        System.out.println("TestReadByTitle");
        when(roleDAO.readByTitle(any(String.class))).thenReturn(testRole);

        Roles resultRole=roleDAO.readByTitle("TestUser");

        assertNotNull(resultRole);
        assertSame(resultRole.getId(),resultRole.getId());
        assertEquals(testRole,resultRole);
    }

}