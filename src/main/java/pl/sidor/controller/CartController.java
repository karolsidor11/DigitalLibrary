package pl.sidor.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.sidor.model.Book;
import pl.sidor.service.BookService;
import pl.sidor.service.CartService;
import pl.sidor.service.UserService;

import java.util.List;

@Controller
public class CartController {

    private static final Logger loger = LoggerFactory.getLogger(CartController.class);

    private UserService userService;
    private BookService bookService;
    private CartService cartService;

    @Autowired
    public CartController(UserService userService, BookService bookService, CartService cartService) {
        this.userService = userService;
        this.bookService = bookService;
        this.cartService = cartService;
    }

    @PostMapping(value = "getBooks")
    public String takeBook(Model model, @RequestParam String book) {
        System.out.println("tytuł" + book);
        List<Book> byTitle = bookService.findByTitle(book);
        cartService.addOrder(byTitle.get(0));

        cartService.findAll().forEach(e -> System.out.println(e.getTitle() + e.getAuthor()));

        model.addAttribute("info", "Wypożyczyłeś książkę " + byTitle.get(0).getTitle() + " !!!");
        model.addAttribute("books", bookService.findAll());
        model.addAttribute("user", getName());
        model.addAttribute("count", cartService.findAll().size());
        return "userPage";
    }

    @GetMapping(value = "showOrder")
    public String showOrder(Model model) {
        model.addAttribute("user", getName());
        model.addAttribute("order", cartService.findAll());
        model.addAttribute("count", cartService.findAll().size());
        model.addAttribute("info", "Brak zamówionych książek !!!");
        return "userPage";

    }

    private String getName() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

}
