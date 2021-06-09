package eu.senla.statkevich.scooters.service;

import eu.senla.statkevich.scooters.dao.implementations.RoleDAO;
import eu.senla.statkevich.scooters.dao.implementations.UserDAO;
import eu.senla.statkevich.scooters.dao.repository.UsersRepository;
import eu.senla.statkevich.scooters.dto.UserDTO;
import eu.senla.statkevich.scooters.entity.entities.Roles;
import eu.senla.statkevich.scooters.entity.entities.Users;
import eu.senla.statkevich.scooters.service.mappers.IUserMapper;
import eu.senla.statkevich.scooters.service.implementations.UserServiceImpl;
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
import org.springframework.security.crypto.password.PasswordEncoder;


import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest extends TestCase {

    @Mock
    private UsersRepository usersRepository;

    @Mock
    private UserDAO userDAO;
    @Mock
    private RoleDAO roleDAO;
    @Mock
    private PasswordEncoder passwordEncoder;
    @Spy
    IUserMapper userMapper = Mappers.getMapper(IUserMapper.class);
    @InjectMocks
    private UserServiceImpl userService;

    private static Users testUser;
    private static List<Users> testUsersList;
    private static Roles testRole;

    @BeforeClass
    public static void prepareTestData() {
        testUser = new Users("Ann");
        testUser.setPass("pass");
        testUser.setPhoneNumber("123ann");

        testRole = new Roles("User");

        testUsersList = new ArrayList<>();
        testUsersList.add(testUser);
    }

    //@Test
    public void testRead() {
        when(userDAO.read(any(Long.class))).thenReturn(testUser);

        UserDTO resultUserDTO = userService.read(1L);

        Mockito.verify(userDAO).read(1L);
        assertNotNull(resultUserDTO);
        assertEquals(resultUserDTO.getName(), userMapper.userToUserDto(testUser).getName());
    }

    @Test
    public void testReadByName() {
        when(usersRepository.findByName(any(String.class))).thenReturn(testUser);

        UserDTO resultUserDTO = userService.readByName("Ann");

        Mockito.verify(usersRepository).findByName("Ann");
        assertNotNull(resultUserDTO);
        assertEquals(resultUserDTO.getName(), userMapper.userToUserDto(testUser).getName());
    }



    @Test
    public void testCreate() {
        when(userDAO.create(any(Users.class))).thenReturn(testUser);
        when(roleDAO.readByTitle(any(String.class))).thenReturn(testRole);
        when(passwordEncoder.encode(any(String.class))).thenReturn("pass");

        UserDTO testUserDTO = userMapper.userToUserDto(testUser);
        UserDTO resultUser = userService.create(testUserDTO);

        Mockito.verify(userDAO).create(any(Users.class));
        assertNotNull(resultUser);
    }

}