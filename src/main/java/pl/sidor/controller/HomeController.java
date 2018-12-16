package pl.sidor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.sidor.dao.BookRepo;
import pl.sidor.utils.UserDAO;
import pl.sidor.dao.UserRepo;
import pl.sidor.daoImpl.BookDAOImpl;
import pl.sidor.model.Book;
import pl.sidor.model.Login;
import pl.sidor.model.User;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class HomeController {

    private UserDAO userDAO;
    private UserRepo userRepo;
    private BookDAOImpl bookDAO;
    private BookRepo bookRepo;


    @Autowired
    public HomeController(UserDAO userDAO, UserRepo userRepo, BookDAOImpl bookDAO, BookRepo bookRepo) {
        this.userDAO = userDAO;
        this.userRepo = userRepo;
        this.bookDAO = bookDAO;
        this.bookRepo = bookRepo;
    }

    @RequestMapping(value = "/", method = GET)
    public String home(Model model) {
//        initUsers();
//        initBooks();
        return "home";
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }


    private void initUsers() {
        List<User> allUser = userDAO.getAllUser();

        for (User user : allUser) {

            String name = user.getName();
            String lastName = user.getLastName();
            String adres = user.getAdres();
            String email = user.getEmail();
            String password = user.getLogin().getPassword();
            String login = user.getLogin().getLogin();

            User user1 = new User(adres, email, lastName, name, new Login(login, password));
            userRepo.save(user1);
        }
    }

    private void initBooks() {

        List<Book> allBook = bookDAO.getAllBook();

        for (Book books : allBook) {

            String author = books.getAuthor();
            String title = books.getTitle();
            int pages = books.getPages();
            String isbn = books.getISBN();

            Book book = new Book(isbn, author, pages, title);

            bookRepo.save(book);

        }
    }
}
