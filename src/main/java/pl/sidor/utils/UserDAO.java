package pl.sidor.utils;

import pl.sidor.model.User;

import java.util.List;

public interface UserDAO {

    List<User> getAllUser();

    User addUser(User user);

    void deleteUser(int id);

    void updateUser(User user);

}
