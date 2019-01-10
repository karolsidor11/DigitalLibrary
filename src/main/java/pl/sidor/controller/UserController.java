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
import org.springframework.web.bind.annotation.RequestParam;
import pl.sidor.model.Book;
import pl.sidor.model.User;
import pl.sidor.service.BookService;
import pl.sidor.service.UserService;

import java.util.List;

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

//    //    WYSZUKIWANIE KSIĄŻKI
//    @PostMapping(value = "/findBook")
//    public String findBook(Model model, @RequestParam(value = "title") String title) {
//        List<Book> byTitle = bookService.findByTitle(title);
//        if (byTitle == null) {
//            model.addAttribute("info", "Nie znaleziono książki o podanym tytule !!!");
//            model.addAttribute("user", getName());
//            return "userPage";
//        }
////        List<Book> books = new ArrayList<>();
////        books.add(byTitle);
//        model.addAttribute("books", byTitle);
//        model.addAttribute("user", getName());
//
////        return "userPanel";
//        return "userPage";
//    }

//    //    LISTA WSZYTSKICH KSIĄŻEK
//    @GetMapping(value = "/allBooks")
//    public String allBooks(Model model) {
//        model.addAttribute("user", getName());
//        model.addAttribute("books", bookService.findAll());
////        return "userPanel";
//        return "userPage";
//    }

    // USUWANIE KONTA UŻYTKOWANIKA
    @GetMapping(value = "/deleteAccount")
    public String deleteAccount(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        Integer id = userService.findByName(name).getId();
        userService.delete(id);
        model.addAttribute("error", "Twoje konto zostało pomyślnie usuniętę !!! ");
        return "redirect:/logout";
    }


    //    MODYFIKACJA KONTA UŻYTKOWNIKA
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
        model.addAttribute("info", "Zmiany na koncie zostały pomyślnie zapisane !!!");

//        return "userPanel";
        return "userPage";
    }


//    //    DODAWANIE NOWEJ KSIĄŻKI
//    @GetMapping(value = "/addBooks")
//    public String addBook(Model model) {
//        model.addAttribute("books", "Przechodze do dodawanania  nowej książki");
//        return "manageBooks";
//    }
//
//    @PostMapping("/newBook")
//    public String newBook(Model model, @ModelAttribute Book book, Errors errors) {
//
//        if (errors.hasErrors()) {
//            model.addAttribute("error", "Nieprawidłowo wypełniony formularz !!!");
//
//            return "manageBooks";
//        }
//
//        bookService.add(book);
//
//        model.addAttribute("user", getName());
//        model.addAttribute("info", "Książka pomyślnie została dodana do zasobów !!!");
//        model.addAttribute("books", bookService.findAll());
//
////        return "userPanel";
//        return "userPage";
//    }

    private String getName() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}
