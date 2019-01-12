package pl.sidor.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
import java.util.stream.Collectors;

@Controller
public class OrderManagementController {

    private UserService userService;
    private BookService bookService;
    private CartService cartService;

    @Autowired
    public OrderManagementController(UserService userService, BookService bookService, CartService cartService) {
        this.userService = userService;
        this.bookService = bookService;
        this.cartService = cartService;
    }

    @GetMapping(value = "manageOrder")
    public String manageOrder(Model model) {
        model.addAttribute("order", cartService.findAll());
        model.addAttribute("books", bookService.findAll());
        return "orderManagement";
    }

    @PostMapping(value = "deleteOrder")
    public String deleteOrder(Model model, @RequestParam Integer id) {
        List<Book> all = cartService.findAll();
        List<Book> collect = all.stream().filter(e -> e.getId().equals(id)).collect(Collectors.toList());
        cartService.removeOrder(collect.get(0));
        model.addAttribute("order", cartService.findAll());
        model.addAttribute("books", bookService.findAll());
        model.addAttribute("info", "Ksiażka  została usunięta z zamówienia !!!");
        return "orderManagement";
    }

    @PostMapping(value = "addOrder")
    public String addOrder(Model model, @RequestParam String book) {
        List<Book> byTitle = bookService.findByTitle(book);
        cartService.addOrder(byTitle.get(0));
        model.addAttribute("books", bookService.findAll());
        model.addAttribute("order", cartService.findAll());
        model.addAttribute("info", "Książka " + byTitle.get(0).getTitle() + " została dodana do zamówienia !!!");
        return "orderManagement";

    }
}
