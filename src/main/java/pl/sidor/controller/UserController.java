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
import pl.sidor.model.Book;
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

    @PostMapping(value = "/findBook")
    public String findBook() {
        return "userPanel";
    }

    // USUWANIE KONTA UŻYTKOWANIKA
    @GetMapping(value = "/deleteAccount")
    public String deleteAccount(Model model) {
        int userID = getUserID();
        userService.delete(userID);
        model.addAttribute("info", "Twoje konto zostało pomyślnie usuniętę !!! ");
        return "home";
    }


    //    MODYFIKACJA KONTA UŻYTKOWNIKA
    @GetMapping(value = "updateAccount")
    public String modifyAccount() {
        return "modifyAccount";
    }

    @PostMapping(value = "/updateAccount")
    public String modifyAccount(Model model, @ModelAttribute User user) {

        userService.update(user);

        model.addAttribute("user", user);
        model.addAttribute("books", bookService.findAll());
        model.addAttribute("info", "Zmiany na koncie zostały pomyślnie zapisane !!!");

        return "userPanel";
    }


    //    DODAWANIE NOWEJ KSIĄŻKI
    @GetMapping(value = "/addBooks")
    public String addBook(Model model) {
        model.addAttribute("books", "Przechodze do dodawanania  nowej książki");

        return "manageBooks";
    }

    @PostMapping("/newBook")

    public String newBook(Model model, @ModelAttribute Book book) {


        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String name = authentication.getName();

        bookService.add(book);

        model.addAttribute("user", name);
        model.addAttribute("info", "Książka pomyślnie została dodana do zasobów !!!");
        model.addAttribute("books", bookService.findAll());
        return "userPanel";
    }

    //    Metoda zwracająca id zalogowanego użytkownika
    private int getUserID() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();

        System.out.println(name);
        User byName = userService.findByName(name);

        return byName.getId();
    }
}
