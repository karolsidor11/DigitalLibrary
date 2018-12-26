package pl.sidor.dao;

import pl.sidor.model.User;

import java.util.List;


public interface UserDao {

    User findByName(String name);

    List<User> findAll();

    void add(User user);

    User findByLoginAndPassword(String login, String password);

    void delete(int id);

    void update(User user);


}