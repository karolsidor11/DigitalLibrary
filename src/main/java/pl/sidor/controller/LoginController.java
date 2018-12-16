package pl.sidor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.sidor.dao.BookRepo;
import pl.sidor.dao.LoginRepo;
import pl.sidor.dao.UserRepo;
import pl.sidor.model.Book;
import pl.sidor.model.Login;
import pl.sidor.model.User;

import javax.validation.Valid;
import java.util.List;

@Controller
public class LoginController {

    private BookRepo bookRepo;
    private UserRepo userRepo;
    private LoginRepo loginRepo;

    @Autowired
    public LoginController(BookRepo bookRepo, UserRepo userRepo, LoginRepo loginRepo) {
        this.bookRepo = bookRepo;
        this.userRepo = userRepo;
        this.loginRepo = loginRepo;
    }

    @RequestMapping(value = "loginProcess", method = RequestMethod.POST)
    public String log(Model model, @Valid @ModelAttribute("Login") Login login, Errors errors) {

        List<Book> allBooks = bookRepo.findAll();

        if (errors.hasErrors()) {
            model.addAttribute("error", "Wprowadź prawidłowe dane logowania !!!");
            return "login";
        }

        Login byLoginAndPassword = loginRepo.findByLoginAndPassword(login.getLogin(), login.getPassword());
        User byLogin = userRepo.findByLogin(byLoginAndPassword);

        User byName = userRepo.findByName(byLogin.getName());

        model.addAttribute("books", allBooks);

//        model.addAttribute("user", byLogin);


//        User byLogin = userRepo.findByLogin(login);
//
//        System.out.println(byLogin.getLogin().getLogin());


//        if (login != null && login.getLogin().equals("admin") && login.getPassword().equals("admin")) {
//            model.addAttribute("books", allBook);
//            model.addAttribute("users", allUser);
//            return "adminPanel";
//        }
//
//        User user = allUser.stream().filter(e -> e.getLogin().getLogin().equals(login.getLogin())).findFirst().get();
//        if (login.getLogin().equals(user.getLogin().getLogin()) && login.getPassword().equals(user.getLogin().getPassword())) {
//            model.addAttribute("user", user);
//            model.addAttribute("books", allBook);
//            return "userPanel";
//        } else {
//            model.addAttribute("error", "Nieprawidłowy login lub hasło !!!");
//            return "login";
//        }

        return "userPanel";
    }
}

