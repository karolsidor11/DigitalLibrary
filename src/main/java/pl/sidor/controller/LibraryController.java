package pl.sidor.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

@Controller
public class LibraryController {

    private static final Logger logger = LoggerFactory.getLogger(LibraryController.class);

    private BookService bookService;
    private UserService userService;

    @Autowired
    public LibraryController(BookService bookService, UserService userService) {
        this.bookService = bookService;
        this.userService = userService;
    }

    @PostMapping("/insertBook")
    public String newBook(Model model, @ModelAttribute Book book, Errors errors) {

        if (errors.hasErrors()) {
            model.addAttribute("error", "Nieprawidłowo wypełniony formularz !!!");
            return "manageLibrary";
        }
        bookService.add(book);

        model.addAttribute("info", "Książka pomyślnie została dodana do zasobów !!!");
        model.addAttribute("actualDate",LoginController.getActualDate());
        model.addAttribute("books", bookService.findAll());

        return "manageLibrary";
    }

    @GetMapping(value = "/getBook")
    public String getBook(Model model) {
        model.addAttribute("books", bookService.findAll());
        model.addAttribute("actualDate",LoginController.getActualDate());

        return "manageLibrary";
    }

    @PostMapping(value = "modifyBook")
    public String modifyBook(Model model) {
        model.addAttribute("books", bookService.findAll());
        model.addAttribute("actualDate",LoginController.getActualDate());

        return "manageLibrary";
    }

    @PostMapping(value = "/deleteBook")
    public String deleteBook(Model model, @RequestParam("id") int id) {

        bookService.delete(id);
        model.addAttribute("books", bookService.findAll());
        model.addAttribute("actualDate",LoginController.getActualDate());

        model.addAttribute("info", "Książka została usunięta z biblioteki !!!");

        return "manageLibrary";
    }
}
