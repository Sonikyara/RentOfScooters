package eu.senla.statkevich.scooters.service;

import eu.senla.statkevich.scooters.dao.UserDAO;
import eu.senla.statkevich.scooters.dto.UserDTO;
import eu.senla.statkevich.scooters.entity.Users;
import eu.senla.statkevich.scooters.service.mappers.IUserMapper;
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

import java.util.ArrayList;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest extends TestCase {

    @Mock
    private UserDAO userDAO;
    @Spy
    IUserMapper userMapper = Mappers.getMapper(IUserMapper.class);
    @InjectMocks
    private UserServiceImpl userService;

    private static Users testUser;

    @BeforeClass
    public static void prepareTestData() {
        testUser=new Users("Ann");

    }

    @Test
    public void testRead() {
        when(userDAO.read(any(Long.class))).thenReturn(testUser);

        UserDTO resultUserDTO = userService.read(1L);

        Mockito.verify(userDAO).read(1L);
        assertNotNull(resultUserDTO);
        assertEquals(resultUserDTO.getName(), userMapper.userToUserDto(testUser).getName());
    }
    @Test
    public void testReadByName() {
        when(userDAO.readByName(any(String.class))).thenReturn(testUser);

        UserDTO resultUserDTO = userService.readByName("Ann");

        Mockito.verify(userDAO).readByName("Ann");
        assertNotNull(resultUserDTO);
        assertEquals(resultUserDTO.getName(), userMapper.userToUserDto(testUser).getName());
    }

    public void testCreate() {
    }

}