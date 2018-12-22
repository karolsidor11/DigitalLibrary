package pl.sidor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.sidor.dao.BookDao;
import pl.sidor.dao.UserDao;
import pl.sidor.model.Book;
import pl.sidor.model.User;

import java.util.List;

@Controller
public class LoginController {

    private UserDao userDao;
    private BookDao bookDao;

    @Autowired
    public LoginController(UserDao userDao, BookDao bookDao) {
        this.userDao = userDao;
        this.bookDao = bookDao;
    }

    @GetMapping(value = "/login")
    public String login() {
        return "login";
    }


    @PostMapping(value = "/loginProcess")
    public String loginProcess(Model model) {

        List<User> allUsers = userDao.findAll();
        List<Book> allBooks = bookDao.findAll();

        model.addAttribute("users", allUsers);
        model.addAttribute("books", allBooks);


        return "userPanel";
    }
}
