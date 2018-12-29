package pl.sidor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.sidor.dao.BookDao;
import pl.sidor.dao.UserDao;
import pl.sidor.model.Book;
import pl.sidor.model.User;

@Controller
public class UserController {

    private UserDao userDao;
    private BookDao bookDao;


    @Autowired
    public UserController(UserDao userDao, BookDao bookDao) {
        this.userDao = userDao;
        this.bookDao = bookDao;
    }

    @PostMapping(value = "/findBook")
    public String findBook() {
        return "userPanel";
    }

    // USUWANIE KONTA UŻYTKOWANIKA
    @GetMapping(value = "/deleteAccount")
    public String deleteAccount(Model model) {
        int userID = getUserID();
        userDao.delete(userID);
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

        userDao.update(user);

        model.addAttribute("user", user);
        model.addAttribute("books", bookDao.findAll());
        model.addAttribute("info", "Zmiany na koncie zostały pomyślnie zapisane !!!");

        return "userPanel";
    }


    //    DODAWANIE NOWEJ KSIĄŻKI
    @GetMapping(value = "/addBooks")
    public String addBook() {
        return "manageBooks";
    }

    @PostMapping("/newBook")
    public String newBook(Model model, @ModelAttribute Book book) {

        User byName = userDao.findByName(LoginController.getThisUser().getName());

        bookDao.add(book);

        model.addAttribute("user", byName);
        model.addAttribute("info", "Książka pomyślnie została dodana do zasobów !!!");
        model.addAttribute("books", bookDao.findAll());
        return "userPanel";
    }

    //    Metoda zwracająca id zalogowanego użytkownika
    private int getUserID() {

        Integer id = LoginController.getThisUser().getId();
        return id;
    }
}
