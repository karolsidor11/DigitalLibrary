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
import pl.sidor.model.Book;
import pl.sidor.service.BookService;
import pl.sidor.service.CartService;
import pl.sidor.service.UserService;

import java.util.List;

@Controller
public class BookController {

    private static final Logger logger = LoggerFactory.getLogger(BookController.class);
    private BookService bookService;
    private UserService userService;
    private CartService cartService;


    @Autowired
    public BookController(BookService bookService, UserService userService, CartService cartService) {
        this.bookService = bookService;
        this.userService = userService;
        this.cartService = cartService;
    }

    @GetMapping(value = "/allBook")
    public String allBooks(Model model) {
        model.addAttribute("books", bookService.findAll());
        model.addAttribute("user", getName());
        model.addAttribute("count", cartService.findAll().size());
        model.addAttribute("actualDate", LoginController.getActualDate());
        return "userPage";
    }

    @PostMapping(value = "/findBooks")
    public String findBooks(Model model, @RequestParam(value = "title") String title) {
        List<Book> byTitle = bookService.findByTitle(title);
        if (byTitle == null || byTitle.isEmpty()) {
            model.addAttribute("info", "Nie znaleziono książki o podanym tytule !!!");
            model.addAttribute("user", getName());
            model.addAttribute("actualDate", LoginController.getActualDate());
            return "userPage";
        }
        model.addAttribute("books", byTitle);
        model.addAttribute("user", getName());
        model.addAttribute("actualDate", LoginController.getActualDate());

        return "userPage";
    }

    @GetMapping(value = "/addBooks")
    public String addBook(Model model) {
        model.addAttribute("books", "Przechodze do dodawanania  nowej książki");
        model.addAttribute("actualDate", LoginController.getActualDate());
        return "manageBooks";
    }

    @PostMapping("/newBook")
    public String newBook(Model model, @ModelAttribute Book book, Errors errors) {

        if (errors.hasErrors()) {
            model.addAttribute("error", "Nieprawidłowo wypełniony formularz !!!");
            model.addAttribute("actualDate", LoginController.getActualDate());

            return "manageBooks";
        }
        bookService.add(book);
        model.addAttribute("user", getName());
        model.addAttribute("actualDate", LoginController.getActualDate());
        model.addAttribute("info", "Książka pomyślnie została dodana do zasobów !!!");
        model.addAttribute("books", bookService.findAll());

        return "userPage";
    }

    @PostMapping("updateBook")
    public String modifyBook(Model model, @RequestParam String book) {
        System.out.println(book);
        List<Book> byTitle = bookService.findByTitle(book);
        Book book1 = byTitle.get(0);
        model.addAttribute("books", bookService.findAll());
        model.addAttribute("updateBook", book1);
        return "manageLibrary";
    }

    @PostMapping("modifiedBook")
    public String updateBook(Model model, @ModelAttribute Book book) {
        bookService.update(book);
        model.addAttribute("books", bookService.findAll());
        model.addAttribute("actualDate", LoginController.getActualDate());
        model.addAttribute("info", "Książka " + book.getTitle() + " została zmodyfikowana !!!");

        return "manageLibrary";
    }

    private String getName() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}
