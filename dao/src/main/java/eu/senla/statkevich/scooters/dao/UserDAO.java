package eu.senla.statkevich.scooters.dao;

import eu.senla.statkevich.scooters.entity.Users;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDAO {

    @Autowired
    private HibernateSessionFactoryUtil sessionUtil;

    public Users getUserByID(int id){
        return sessionUtil.getSession().get(Users.class, id);
    }

    public void saveUser(Users user) {
        Session session = sessionUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();
    }
}
