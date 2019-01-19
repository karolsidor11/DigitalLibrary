package pl.sidor.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.sidor.service.BookService;
import pl.sidor.service.UserService;

@Controller
public class AdminController {

    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

    private UserService userService;
    private BookService bookService;

    @Autowired
    public AdminController(UserService userService, BookService bookService) {
        this.userService = userService;
        this.bookService = bookService;
    }

    @GetMapping(value = "/addBook")
    public String addBook(Model model) {

        model.addAttribute("info", "Książka została dodana do bazy danych !!!");
        model.addAttribute("actualDate", LoginController.getActualDate());
        return "manageBooks";
    }

    @GetMapping(value = "/manageUsers")
    public String addUser(Model model) {
        model.addAttribute("users", userService.findAll());
        model.addAttribute("actualDate", LoginController.getActualDate());
        return "manageUsers";
    }

    @GetMapping(value = "/manageLibrary")
    public String manageLibrary(Model model) {

        model.addAttribute("books", bookService.findAll());
        model.addAttribute("actualDate", LoginController.getActualDate());

        return "manageLibrary";
    }

    @GetMapping("addNewAdmin")
    public String addNewAdmin(Model model) {
        model.addAttribute("info", "Funkcjonalność dodawania uprawnień Administratora jest w budowie :( \n \n PRZEPRASZAMY !!!");
        model.addAttribute("actualDate", LoginController.getActualDate());
        model.addAttribute("user", getName());
        return "userPage";
    }

    @GetMapping("modifyAdminAccount")
    public String modifyAdminAccount(Model model) {
        model.addAttribute("info", "Funkcjonalność modyfikowania konta Administratora jest w budowie :( \n \n PRZEPRASZAMY !!!");
        model.addAttribute("actualDate", LoginController.getActualDate());
        model.addAttribute("user", getName());
        return "userPage";
    }

    private String getName() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}
