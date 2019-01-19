package pl.sidor.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.sidor.model.User;
import pl.sidor.service.BookService;
import pl.sidor.service.UserService;

@Controller
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    private UserService userService;
    private BookService bookService;

    @Autowired
    public UserController(UserService userService, BookService bookService) {
        this.userService = userService;
        this.bookService = bookService;
    }

    @GetMapping(value = "/deleteAccount")
    public String deleteAccount(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        Integer id = userService.findByName(name).getId();
        userService.delete(id);
        model.addAttribute("error", "Twoje konto zostało pomyślnie usuniętę !!! ");
        return "redirect:/logout";
    }

    @GetMapping(value = "updateAccount")
    public String modifyAccount(Model model) {
        User byName = userService.findByName(getName());
        model.addAttribute("user", byName);
        return "modifyAccount";
    }

    @PostMapping(value = "/updateAccount")
    public String modifyAccount(Model model, @ModelAttribute User user) {

        userService.update(user);
        model.addAttribute("user", user.getName());
        model.addAttribute("actualDate", LoginController.getActualDate());
        model.addAttribute("info", "Zmiany na koncie zostały pomyślnie zapisane !!!");

        return "userPage";
    }

    @GetMapping("/modifyUser")
    public String modifyUser(Model model) {

        model.addAttribute("actualDate", LoginController.getActualDate());
        model.addAttribute("info", "Ta funkcja obecnie jest zablokowana !!!");

        return "manageUsers";
    }

    private String getName() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}
