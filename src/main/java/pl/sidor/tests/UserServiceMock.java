package pl.sidor.tests;

import pl.sidor.model.User;
import pl.sidor.service.UserService;

import java.util.ArrayList;
import java.util.List;

public class UserServiceMock implements UserService {

    private List<User> userList = new ArrayList<>();


    @Override
    public User findByName(String name) {

        return userList.stream().filter(user -> user.getName().equals(name)).findFirst().get();
    }

    @Override
    public List<User> findAll() {
        return userList;
    }

    @Override
    public void add(User user) {
        userList.add(user);
    }

    @Override
    public User findByLoginAndPassword(String login, String password) {
        return null;
    }

    @Override
    public void delete(int id) {
        User user1 = userList.stream().filter(user -> user.getId().equals(id)).findFirst().get();
        userList.remove(user1);

    }

    @Override
    public void update(User user) {

        User user2 = userList.stream().filter(user1 -> user1.getId().equals(user.getId())).findFirst().get();

        user2.setName(user.getName());
        user2.setEmail(user.getEmail());
        user2.setLogin(user.getLogin());
        user2.setPassword(user.getPassword());

        userList.add(user2);
    }
}
