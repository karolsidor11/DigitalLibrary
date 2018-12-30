package pl.sidor.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.sidor.model.Book;
import pl.sidor.model.User;
import pl.sidor.service.BookService;
import pl.sidor.service.UserService;

import java.util.List;

@Controller
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    private BookService bookService;
    private UserService userService;

    public static User getThisUser() {
        return thisUser;
    }

    private static User thisUser;


    public LoginController(BookService bookService, UserService userService) {
        this.bookService = bookService;
        this.userService = userService;
    }

    @GetMapping(value = "/login")
    public String login() {
        return "login";
    }


    @GetMapping("/userPanel")
    public String getUserPanel(Model model) {

        List<Book> all = bookService.findAll();

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();

        model.addAttribute("users", name);
        model.addAttribute("books", all);

        return "userPanel";
    }

}
