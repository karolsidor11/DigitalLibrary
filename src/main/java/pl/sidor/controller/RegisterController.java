package pl.sidor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.sidor.dao.BookDao;
import pl.sidor.dao.UserDao;
import pl.sidor.model.Book;
import pl.sidor.model.User;

import javax.validation.Valid;
import java.util.List;

@Controller
public class RegisterController {


    private BookDao bookDao;
    private UserDao userDao;
    public static User getThisUser() {
        return thisUser;
    }

    private static User thisUser;


    @Autowired
    public RegisterController(BookDao bookDao, UserDao userDao) {
        this.bookDao = bookDao;
        this.userDao = userDao;
    }

    @GetMapping(value = "/register")
    public String register() {

        return "register";
    }


    @PostMapping()
    public String registerIN(Model model, @Valid @ModelAttribute User user, Errors errors) {

        if (errors.hasErrors()) {
            model.addAttribute("errors", "Nieprawidłowo wypełniony formularz rejestracji !!!");
            return "register";
        }

        List<Book> all = bookDao.findAll();

        String name = user.getName();
        String email = user.getEmail();
        Integer id = user.getId();
        String login = user.getLogin();
        String password = user.getPassword();
        User user1 = new User(id, name, email, login, password);
        userDao.add(user1);

        model.addAttribute("user", user1);
        model.addAttribute("books", all);

        return "userPanel";
    }
}
