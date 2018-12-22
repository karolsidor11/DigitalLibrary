package pl.sidor.dao;

import pl.sidor.model.User;

import java.util.List;


public interface UserDao {

    User findByName(String name);

    List<User> findAll();

    void add(User user);

}