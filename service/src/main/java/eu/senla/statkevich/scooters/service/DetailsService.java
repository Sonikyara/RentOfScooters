package eu.senla.statkevich.scooters.service;

import eu.senla.statkevich.scooters.dao.IUserDao;
import eu.senla.statkevich.scooters.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DetailsService implements UserDetailsService {

    @Autowired
    private IUserDao userDAO;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        Users user=userDAO.readByName(name);
        if (user==null){
            throw new UsernameNotFoundException("Unknown user: "+name);
        }
//        ArrayList listRoles = null;
//        listRoles.add(new SimpleGrantedAuthority("user"));

        UserDetails userDetails = User.builder()
                .username(user.getName())
                .password(user.getPass())
                .roles(user.getRole().getTitle())
                .build();
        return userDetails;
    }
}
