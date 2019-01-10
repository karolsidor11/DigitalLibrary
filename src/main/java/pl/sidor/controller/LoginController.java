package pl.sidor.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.sidor.service.BookService;
import pl.sidor.service.UserService;

@Controller
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    private BookService bookService;
    private UserService userService;

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

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();

        model.addAttribute("user", name);

        return "userPage";
    }

    @GetMapping("/badLogin")
    public String badLogin(Model model) {
        model.addAttribute("error", "Nieprawidłowy login lub hasło !!!");
        return "login";
    }

    @GetMapping("/logout")
    public String logout(Model model) {
        model.addAttribute("logout", "Zostałeś poprawnie wylogowany !!!");
        return "login";

    }

    @GetMapping(value = "/userPage")
    public String home(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        if (name.equals("admin")) {
            model.addAttribute("user", name);
        } else {
            model.addAttribute("user", name);
        }
        return "userPage";
    }

}
