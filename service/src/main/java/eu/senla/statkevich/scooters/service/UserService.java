package eu.senla.statkevich.scooters.service;

import eu.senla.statkevich.scooters.dao.IGenericDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import eu.senla.statkevich.scooters.dao.UserDAO;
import eu.senla.statkevich.scooters.dto.UserDTO;
import eu.senla.statkevich.scooters.entity.Users;

@Service
public class UserService { //может, имплементить общий интерфейс?

    @Autowired
    private UserDAO userDAO;
    //private IGenericDao userDAO;  //for transaction

    public UserService() {
    }

    public UserDTO getUserById(long id) {
        return UserDTO.getUserDTO((Users) userDAO.read(id));
    }

    public void saveUser(Users user) {
        userDAO.create(user);
    }

}
