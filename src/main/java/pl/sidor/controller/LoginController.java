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

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

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

        model.addAttribute("user", getName());
        model.addAttribute("actualData", getActualDate());

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

        if (getName().equals("admin")) {
            model.addAttribute("user", getName());
            model.addAttribute("actualDate",LoginController.getActualDate());
        } else {
            model.addAttribute("user", getName());
            model.addAttribute("actualDate",LoginController.getActualDate());
        }
        return "userPage";
    }

    private String getName() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
    public static String getActualDate(){
        Date date= new Date();
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");

        return sdf.format(date);

    }

}
