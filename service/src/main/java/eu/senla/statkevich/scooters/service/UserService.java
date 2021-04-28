package eu.senla.statkevich.scooters.service;

import eu.senla.statkevich.scooters.dao.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import eu.senla.statkevich.scooters.dto.UserDTO;
import eu.senla.statkevich.scooters.entity.Users;

@Service
public class UserService implements UsersService{

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UserDTO read(long id) {
        return UserDTO.getUserDTO(usersRepository.findById(id).orElse(new Users()));
    }

    @Override
    public void create(Users user) {

    }
}
