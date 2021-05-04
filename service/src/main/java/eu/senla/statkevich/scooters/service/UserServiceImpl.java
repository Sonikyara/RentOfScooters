package eu.senla.statkevich.scooters.service;

import eu.senla.statkevich.scooters.dao.IRoleDao;
import eu.senla.statkevich.scooters.dao.IUserDao;
import eu.senla.statkevich.scooters.dao.UserDAO;
import eu.senla.statkevich.scooters.dao.repository.UsersRepository;
import eu.senla.statkevich.scooters.entity.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import eu.senla.statkevich.scooters.dto.UserDTO;
import eu.senla.statkevich.scooters.entity.Users;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@Transactional
public class UserServiceImpl implements UsersService{

//    @Autowired
//    private UsersRepository usersRepository;

    @Autowired
    private IUserMapper userMapper;
    @Autowired
    private IUserDao userDAO;
    @Autowired
    private IRoleDao roleDAO;

    @Autowired
    private PasswordEncoder passwordEncoder;
//---for security ?
//    @Autowired
//    AuthenticationManagerBuilder auth;
//-----
    @Override
    public UserDTO read(Long id) {
        return userMapper.userToUserDto(userDAO.read(id));
    }

    @Override
    public UserDTO readByName(String name) {
        return userMapper.userToUserDto(userDAO.readByName(name));
    }

    @Override
    public String create(UserDTO userDTO) {
        Roles role  = roleDAO.readByTitle("USER");
        Users user=userMapper.userDtoToUser(userDTO);
        user.setRole(role);

        user.setPass(passwordEncoder.encode(userDTO.getPass()));

        return (userDAO.create(user)).toString();
    }

    //    @Override
//    public UserDTO read(Long id) {
//        return UserDTO.getUserDTO(usersRepository.findById(id).orElse(new Users()));
//    }

//    @Override
//    public Users create(UserDTO userDTO) {
//
//        //user = userRepository.findOne(userDTO.getId()); - добавить проверку?
//        //Users user= userMapper.userDtoToUser(userDTO);
//        //Roles role= userMapper.roleDtoToRole(userDTO.getRoleDTO());
//
//        Users user = usersRepository.saveAndFlush(userMapper.userDtoToUser(userDTO));
//
//        return user;
//    }
}
