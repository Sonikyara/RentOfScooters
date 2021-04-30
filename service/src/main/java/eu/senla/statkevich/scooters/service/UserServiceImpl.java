package eu.senla.statkevich.scooters.service;

import eu.senla.statkevich.scooters.dao.IUserDao;
import eu.senla.statkevich.scooters.dao.UserDAO;
import eu.senla.statkevich.scooters.dao.repository.UsersRepository;
import eu.senla.statkevich.scooters.entity.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import eu.senla.statkevich.scooters.dto.UserDTO;
import eu.senla.statkevich.scooters.entity.Users;

@Service
public class UserServiceImpl implements UsersService{

//    @Autowired
//    private UsersRepository usersRepository;

    @Autowired
    private IUserMapper userMapper;

    @Autowired
    private IUserDao userDAO;

    @Override
    public UserDTO read(Long id) {
        return userMapper.userToUserDto(userDAO.read(id));
    }
    @Override
    public Users create(UserDTO userDTO) {
        return userDAO.create(userMapper.userDtoToUser(userDTO));
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
