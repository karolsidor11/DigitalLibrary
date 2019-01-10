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

//    @PostMapping("/deleteUser")
//    public String deleteUser(Model model, @RequestParam String id) {
//
//        System.out.println(id);
//        userService.delete(Integer.parseInt(id));
//
//        model.addAttribute("info", "Użytkownik został pomyślnie usunięty !!!");
//        model.addAttribute("books", bookService.findAll());
//        model.addAttribute("user", getName());
//        return "userPage";
//
//    }

//    @GetMapping("/deleteBook/{id}")
//    public String deleteBook(@PathVariable Integer id) {
//
//        bookService.delete(id);
////        return "admin";
//        return "userPage";

//    }

//    //    LISTA WSZYTSKICH KSIĄŻEK
//    @GetMapping(value = "/allBook")
//    public String allBooks(Model model) {
//        model.addAttribute("books", bookService.findAll());
//        model.addAttribute("user", "Administratorze");
////        return "admin";
//        return "userPage";
//    }



//    @PostMapping(value = "/findBooks")
//    public String findBooks(Model model, @RequestParam(value = "title") String title) {
//        List<Book> byTitle = bookService.findByTitle(title);
//        if (byTitle == null) {
//            model.addAttribute("info", "Nie znaleziono książki o podanym tytule !!!");
//            model.addAttribute("user", "Administratorze");
//
//            return "userPage";
//        }
//        model.addAttribute("books", byTitle);
//        model.addAttribute("user", "Administratorze");
//
//        return "userPage";
//    }

    @GetMapping(value = "/manageLibrary")
    public String manageLibrary(Model model) {

        model.addAttribute("books", bookService.findAll());
        return "manageLibrary";
    }

//    @PostMapping(value = "/deleteBook")
//    public String deleteBook(Model model, @RequestParam("id") int id) {
//
//       bookService.delete(id);
//        model.addAttribute("info", "Książka została usunięta z biblioteki !!!");
//        return "userPage";
//
//    }

//    @PostMapping(value = "/addUser")
//    public String addUser(Model model, @Valid @ModelAttribute User user, Errors errors) {
//
//        if (errors.hasErrors()) {
//            model.addAttribute("error", "Nieprawidłowo wypełniony formularz !!!");
//            model.addAttribute("books", bookService.findAll());
//            return "manageUsers";
//        }
//        userService.add(user);
//        model.addAttribute("user", getName());
//        model.addAttribute("info", "Użytkownik został pomyślnie dadany do bazy danych !!!");
//
//        return "userPage";
//    }

    private String getName() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}
