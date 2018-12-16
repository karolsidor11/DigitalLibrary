package pl.sidor.daoImpl;

import org.springframework.stereotype.Component;
import pl.sidor.utils.UserDAO;
import pl.sidor.model.Login;
import pl.sidor.model.User;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDAOImlp implements UserDAO {

    private List<User> userList = new ArrayList<User>();

    public List<User> getAllUser() {
        User user = new User("Karol", "Sidor", "karolsidor11@wp.pl", "Lublin", new Login("Karol", "12345"));
        User user1 = new User("Marek", "Nowak", "mareknowak@wp.pl", "Warszawa", new Login("Marek", "qwerty"));
        User user2 = new User("Adrian", "Woliński", "wolińskia@wp.pl", "Kraków", new Login("Adrian", "Adrian"));
        User user3 = new User("Michał", "Szpak", "mszpak@wp.pl", "Lublin", new Login("Michal", "99999"));


        userList.add(user);
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        return userList;
    }

    public User addUser(User user) {
        userList.add(user);
        return user;
    }

    public void deleteUser(int id) {
        userList.remove(id);
    }

    public void updateUser(User user) {

        User user1 = userList.get(user.getId());
        user1.setName(user.getName());
        user1.setLastName(user.getLastName());
        user1.setAdres(user.getAdres());
        user1.setEmail(user.getEmail());
        user1.setLogin(user.getLogin());
    }
}
