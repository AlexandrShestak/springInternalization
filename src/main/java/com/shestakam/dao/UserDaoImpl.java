package com.shestakam.dao;


import com.shestakam.entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by alexandr on 10.7.15.
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(User user) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        //session.persist(user);
        session.save(user);
        tx.commit();
        session.close();
    }

    @Override
    public User get(String login) {
        Session session = this.sessionFactory.openSession();
        User user = session.get(User.class,login);
        session.close();
        return user;
    }

    @Override
    public void edit(User user) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        session.update(user);

        tx.commit();
        session.close();
    }

    @Override
    public void delete(String login) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        User user = session.get(User.class,login);
        session.delete(user);
        tx.commit();
        session.close();
    }



}
