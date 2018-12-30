package pl.sidor.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.sidor.model.Book;
import pl.sidor.model.User;
import pl.sidor.service.BookService;
import pl.sidor.service.UserService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class RegisterController {

    private static final Logger logger = LoggerFactory.getLogger(RegisterController.class);

    private UserService userService;
    private BookService bookService;

    @Autowired
    public RegisterController(UserService userService, BookService bookService) {
        this.userService = userService;
        this.bookService = bookService;
    }

    public static User getThisUser() {
        return thisUser;
    }

    private static User thisUser;


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

        List<Book> all = bookService.findAll();

        String name = user.getName();
        String email = user.getEmail();
        Integer id = user.getId();
        String login = user.getLogin();
        String password = user.getPassword();
        User user1 = new User(id, name, email, login, password);
        userService.add(user1);

        model.addAttribute("user", user1);
        model.addAttribute("books", all);

        return "userPanel";
    }

}
