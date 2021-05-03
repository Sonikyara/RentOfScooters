package eu.senla.statkevich.scooters.service.serviceConfiguration;

import eu.senla.statkevich.scooters.dao.IUserDao;
import eu.senla.statkevich.scooters.entity.Users;
import eu.senla.statkevich.scooters.service.IUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class DetailsService implements UserDetailsService {

    @Autowired
    private IUserDao userDAO;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        Users user=userDAO.readByName(name);
        return new User(user.getName(), user.getPass(), new ArrayList<>());
       // return null;
    }
}
