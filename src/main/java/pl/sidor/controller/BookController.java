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
import pl.sidor.service.UserService;

import java.util.List;

@Controller
public class BookController {

    private static final Logger logger = LoggerFactory.getLogger(BookController.class);
    private BookService bookService;
    private UserService userService;

    @Autowired
    public BookController(BookService bookService, UserService userService) {
        this.bookService = bookService;
        this.userService = userService;
    }

    //    Lista wszytskich książek
    @GetMapping(value = "/allBook")
    public String allBooks(Model model) {
        model.addAttribute("books", bookService.findAll());
        model.addAttribute("user", getName());
        return "userPage";
    }

    //    Wyszukiwanie książki
    @PostMapping(value = "/findBooks")
    public String findBooks(Model model, @RequestParam(value = "title") String title) {
        List<Book> byTitle = bookService.findByTitle(title);
        if (byTitle == null) {
            model.addAttribute("info", "Nie znaleziono książki o podanym tytule !!!");
            model.addAttribute("user", getName());

            return "userPage";
        }
        model.addAttribute("books", byTitle);
        model.addAttribute("user", getName());

        return "userPage";
    }


    //    Dodawanie książki
    @GetMapping(value = "/addBooks")
    public String addBook(Model model) {
        model.addAttribute("books", "Przechodze do dodawanania  nowej książki");
        return "manageBooks";
    }

    @PostMapping("/newBook")
    public String newBook(Model model, @ModelAttribute Book book, Errors errors) {

        if (errors.hasErrors()) {
            model.addAttribute("error", "Nieprawidłowo wypełniony formularz !!!");

            return "manageBooks";
        }

        bookService.add(book);

        model.addAttribute("user", getName());
        model.addAttribute("info", "Książka pomyślnie została dodana do zasobów !!!");
        model.addAttribute("books", bookService.findAll());

        return "userPage";
    }

    //    Usuwanie książki
    @PostMapping(value = "/deleteBook")
    public String deleteBook(Model model, @RequestParam("id") int id) {

        bookService.delete(id);
        model.addAttribute("info", "Książka została usunięta z biblioteki !!!");
        return "userPage";

    }

    @PostMapping("/updateBook")
    public String modifyBook() {
        return "userPage";
    }

    public String getName() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}
