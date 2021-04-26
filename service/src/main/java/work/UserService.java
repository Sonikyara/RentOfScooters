package work;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("singleton")
public class UserService { //может, имплементить общий интерфейс?

    @Autowired
    private UserDAO userDAO;

    public UserService() {
    }

    public UserDTO getUserById(int id) {

        return ConverterToUserDTO.convertUserToUserDTO(userDAO.getUserByID(id));
    }

    public void saveUserById(Users user) {
        userDAO.saveUserByID(user);
    }

}
