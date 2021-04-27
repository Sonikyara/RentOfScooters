package eu.senla.statkevich.scooters.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import eu.senla.statkevich.scooters.dao.UserDAO;
import eu.senla.statkevich.scooters.dto.UserDTO;
import eu.senla.statkevich.scooters.entity.Users;

@Service
public class UserService { //может, имплементить общий интерфейс?

    @Autowired
    private UserDAO userDAO;

    public UserService() {
    }

    public UserDTO getUserById(int id) {
        return UserDTO.getUserDTO(userDAO.getUserByID(id));
    }

    public void saveUser(Users user) {
        userDAO.saveUser(user);
    }

}
