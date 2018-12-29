package pl.sidor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.sidor.dao.BookDao;
import pl.sidor.dao.UserDao;
import pl.sidor.service.BookService;

@Controller
public class AdminController {

    private UserDao userDao;
    private BookDao bookDao;
    private BookService bookService;

    @Autowired
    public AdminController(UserDao userDao, BookDao bookDao, BookService bookService) {
        this.userDao = userDao;
        this.bookDao = bookDao;
        this.bookService = bookService;
    }

    @GetMapping(value = "/addBook")
    public String addBook(Model model) {

        model.addAttribute("info", "Książka została dodana do bazy danych !!!");
        return "manageBooks";
    }

    @GetMapping(value = "/manageUsers")
    public String addUser(Model model) {
        model.addAttribute("users", userDao.findAll());
        return "manageUsers";
    }

    @PostMapping("/deleteUser")
    public String deleteUser(Model model, @RequestParam String id) {

        System.out.println(id);
        userDao.delete(Integer.parseInt(id));

        model.addAttribute("info", "Użytkownik został pomyślnie usunięty !!!");
        model.addAttribute("books", bookDao.findAll());
        return "admin";

    }

    @GetMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable Integer id) {

        bookService.deleteBook(id);
        return "admin";

    }


}
