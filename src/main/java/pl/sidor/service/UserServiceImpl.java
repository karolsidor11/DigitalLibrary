package pl.sidor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sidor.utils.UserDAO;
import pl.sidor.dao.UserRepo;
import pl.sidor.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserDAO userDAO;
    private UserRepo userRepo;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public List<User> getAllUser() {
        return userDAO.getAllUser();
    }

    public void save() {

//        userRepo.findByNameAndLastName("Karol", "Sidor");

    }
}
