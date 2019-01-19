package pl.sidor.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.sidor.model.User;
import pl.sidor.service.BookService;
import pl.sidor.service.UserService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserManagementController {
    private static final Logger logger = LoggerFactory.getLogger(UserManagementController.class);

    private BookService bookService;
    private UserService userService;

    @Autowired
    public UserManagementController(BookService bookService, UserService userService) {
        this.bookService = bookService;
        this.userService = userService;
    }

    @GetMapping(value = "/allUsers")
    public String allUsers(Model model) {
        model.addAttribute("users", userService.findAll());
        model.addAttribute("user", getName());
        model.addAttribute("actualDate",LoginController.getActualDate());
        return "userPage";
    }

    @PostMapping(value = "/addUser")
    public String addUser(Model model, @Valid @ModelAttribute User user, Errors errors) {

        if (errors.hasErrors()) {
            model.addAttribute("info", "Nieprawidłowo wypełniony formularz !!!");
            model.addAttribute("books", bookService.findAll());
            model.addAttribute("actualDate",LoginController.getActualDate());
            model.addAttribute("users", userService.findAll());
            return "manageUsers";
        }
        userService.add(user);
        model.addAttribute("user", getName());
        model.addAttribute("users", userService.findAll());
        model.addAttribute("actualDate",LoginController.getActualDate());
        model.addAttribute("info", "Użytkownik został pomyślnie dodany do bazy danych !!!");

        return "manageUsers";
    }

    @PostMapping("/deleteUser")
    public String deleteUser(Model model, @RequestParam String id) {

        System.out.println(id);
        userService.delete(Integer.parseInt(id));

        model.addAttribute("info", "Użytkownik został pomyślnie usunięty !!!");
        model.addAttribute("users", userService.findAll());
        model.addAttribute("actualDate",LoginController.getActualDate());
        model.addAttribute("user", getName());

        return "manageUsers";
    }

    @PostMapping(value = "findUser")
    public String findUserByName(Model model, @RequestParam String user) {
        User byName = userService.findByName(user);
        List<User> userList = new ArrayList<>();
        userList.add(byName);

        model.addAttribute("users", userList);
        model.addAttribute("user", getName());
        model.addAttribute("actualDate",LoginController.getActualDate());
        return "manageUsers";
    }

    private String getName() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}
