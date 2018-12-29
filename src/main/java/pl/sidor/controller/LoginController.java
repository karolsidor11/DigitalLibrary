package pl.sidor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.sidor.dao.BookDao;
import pl.sidor.dao.UserDao;
import pl.sidor.model.Book;
import pl.sidor.model.User;

import java.util.List;

@Controller
public class LoginController {

    private UserDao userDao;
    private BookDao bookDao;

    public static User getThisUser() {
        return thisUser;
    }

    private static User thisUser;


    @Autowired
    public LoginController(UserDao userDao, BookDao bookDao) {
        this.userDao = userDao;
        this.bookDao = bookDao;
    }

    @GetMapping(value = "/login")
    public String login() {
        return "login";
    }


    @GetMapping("/userPanel")
    public String getUserPanel(Model model) {
        List<User> allUsers = userDao.findAll();
        List<Book> allBooks = bookDao.findAll();


        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName(); //get logged in username


        model.addAttribute("user", name);
        model.addAttribute("books", allBooks);

        return "userPanel";
    }


    @PostMapping(value = "/loginProcess")
    public String loginProcess(Model model, @RequestParam String login, @RequestParam String password) {

        List<User> allUsers = userDao.findAll();
        List<Book> allBooks = bookDao.findAll();

        if (login.isEmpty() || password.isEmpty()) {
            model.addAttribute("errors", "Nieprawidłowo wypełniony formularz logowania !!!");
            return "login";
        }

        try {
            User user = userDao.findByLoginAndPassword(login, password);
            if (user.getName().equals("admin")) {
                model.addAttribute("user", user);
                model.addAttribute("users", allUsers);
                model.addAttribute("books", allBooks);
                return "admin";
            }
            thisUser = user;
            model.addAttribute("user", user);
            model.addAttribute("books", allBooks);
            return "userPanel";

        } catch (EmptyResultDataAccessException e) {
            model.addAttribute("errors", "Nieprawidłowe dane logowania  !!!");
            return "login";
        }

    }
}
