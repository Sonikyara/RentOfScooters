package eu.senla.statkevich.scooters.service;

import eu.senla.statkevich.scooters.dao.RoleDAO;
import eu.senla.statkevich.scooters.dto.RoleDTO;
import eu.senla.statkevich.scooters.entity.Roles;
import eu.senla.statkevich.scooters.service.mappers.IRoleMapper;

import junit.framework.TestCase;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mapstruct.factory.Mappers;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RoleServiceImplTest extends TestCase {

    @Mock
    private RoleDAO roleDAO;
    @Spy
    IRoleMapper roleMapper = Mappers.getMapper(IRoleMapper.class);
    @InjectMocks
    private RoleServiceImpl roleService;

    private static Roles testRole;

    @BeforeClass
    public static void prepareTestData() {
        testRole = new Roles();
        testRole.setTitle("TestUser");
        testRole.setId(10L);
    }

    @Test
    public void testRead() {
        System.out.println("TestById");
        when(roleDAO.read(any(Long.class))).thenReturn(testRole);

        RoleDTO resultRoleDTO = roleService.read(10L);

        Mockito.verify(roleDAO).read(10L);
        assertNotNull(resultRoleDTO);
        assertEquals(resultRoleDTO.getTitle(), roleMapper.roleToRoleDto(testRole).getTitle());

    }

    @Test
    public void testReadByTitle() {
        System.out.println("TestByTitle");
        when(roleDAO.readByTitle(any(String.class))).thenReturn(testRole);

        RoleDTO resultRoleDTO = roleService.readByTitle("TestUser");

        Mockito.verify(roleDAO).readByTitle("TestUser");
        assertNotNull(resultRoleDTO);
        assertEquals(resultRoleDTO.getTitle(), roleMapper.roleToRoleDto(testRole).getTitle());
    }
}