package com.shestakam.dao;


import com.shestakam.entities.User;

/**
 * Created by alexandr on 10.7.15.
 */
public interface UserDao {
    void add(User user);
    User get(String login);
    void edit(User user);
    void delete(String login);
}
