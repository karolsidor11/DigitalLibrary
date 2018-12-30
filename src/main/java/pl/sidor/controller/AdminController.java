package pl.sidor.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
        return "manageBooks";
    }

    @GetMapping(value = "/manageUsers")
    public String addUser(Model model) {
        model.addAttribute("users", userService.findAll());
        return "manageUsers";
    }

    @PostMapping("/deleteUser")
    public String deleteUser(Model model, @RequestParam String id) {

        System.out.println(id);
        userService.delete(Integer.parseInt(id));

        model.addAttribute("info", "Użytkownik został pomyślnie usunięty !!!");
        model.addAttribute("books", bookService.findAll());
        return "admin";

    }

    @GetMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable Integer id) {

//        bookService.deleteBook(id);
        return "admin";

    }


}
