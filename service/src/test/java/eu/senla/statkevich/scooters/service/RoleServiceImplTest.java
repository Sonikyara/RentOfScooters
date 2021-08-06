package eu.senla.statkevich.scooters.service;

import eu.senla.statkevich.scooters.dao.implementations.RoleDAO;
import eu.senla.statkevich.scooters.dto.RoleDTO;
import eu.senla.statkevich.scooters.entity.entities.Roles;
import eu.senla.statkevich.scooters.service.implementations.RoleServiceImpl;
import eu.senla.statkevich.scooters.service.mappers.IRoleMapper;

import eu.senla.statkevich.scooters.service.mappers.IRoleMapperImpl;
import eu.senla.statkevich.scooters.service.services.RolesService;
import junit.framework.TestCase;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mapstruct.factory.Mappers;

import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
//@Import(ServiceImplTestConfig.class)
@SpringBootTest(classes = ServiceImplTestConfig111.class)
public class RoleServiceImplTest extends TestCase {

//    @TestConfiguration
//    //@SpringBootConfiguration
//    public static class ServiceImplTestConfig {
//        @Bean
//        public RolesService roleService() {
//            return new RoleServiceImpl() {
//            };
//        }
//        @Bean
//        public IRoleMapper roleMapper() {
//            return new IRoleMapperImpl() {
//            };
//        }
//    }
    @MockBean
    //@Mock
    private RoleDAO roleDAO;

    //@Spy
//    @SpyBean
//    IRoleMapper roleMapper = Mappers.getMapper(IRoleMapper.class);

    //@InjectMocks

    @Autowired
    private IRoleMapper roleMapper;

    @Autowired
    private RoleServiceImpl roleService;

    private static Roles testRole;

    @BeforeClass
    public static void prepareTestData() {
        testRole = new Roles();
        testRole.setTitle("TestUser");
    }

    @Test
    public void testRead() {
        when(roleDAO.read(any(Long.class))).thenReturn(testRole);

        RoleDTO resultRoleDTO = roleService.read(10L);

        Mockito.verify(roleDAO).read(10L);
        assertNotNull(resultRoleDTO);
        assertEquals(resultRoleDTO.getTitle(), roleMapper.roleToRoleDto(testRole).getTitle());

    }

    @Test
    public void testReadByTitle() {
        when(roleDAO.readByTitle(any(String.class))).thenReturn(testRole);

        RoleDTO resultRoleDTO = roleService.readByTitle("TestUser");

        Mockito.verify(roleDAO).readByTitle("TestUser");
        assertNotNull(resultRoleDTO);
        assertEquals(resultRoleDTO.getTitle(), roleMapper.roleToRoleDto(testRole).getTitle());
    }
}