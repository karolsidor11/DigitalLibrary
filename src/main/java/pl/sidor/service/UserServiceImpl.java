package pl.sidor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sidor.dao.UserDao;
import pl.sidor.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User findByName(String name) {
        User byName = userDao.findByName(name);
        return byName;
    }

    @Override
    public List<User> findAll() {
        List<User> all = userDao.findAll();
        return all;
    }

    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public User findByLoginAndPassword(String login, String password) {
        User byLoginAndPassword = userDao.findByLoginAndPassword(login, password);
        return byLoginAndPassword;
    }

    @Override
    public void delete(int id) {

        userDao.delete(id);
    }

    @Override
    public void update(User user) {

        userDao.update(user);
    }
}
