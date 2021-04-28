package eu.senla.statkevich.scooters.dao;

import eu.senla.statkevich.scooters.entity.Users;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public class UserDAO extends HibernateSession implements IGenericDao{

    @Override
    //    @Transactional
    public Object read(long id) {
        return getSession().get(Users.class, id);
    }

    @Override
    //    @Transactional
    public void create(Object entity) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction(); //delete for Transactional
        session.save(entity);
        transaction.commit();//delete for Transactional
        session.close();
    }

}
