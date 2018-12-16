package pl.sidor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.sidor.dao.BookRepo;
import pl.sidor.dao.UserRepo;
import pl.sidor.model.Book;
import pl.sidor.model.User;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/register")
public class RegisterController {

    private UserRepo userRepo;
    private BookRepo bookRepo;

    @Autowired
    public RegisterController(UserRepo userRepo, BookRepo bookRepo) {
        this.userRepo = userRepo;
        this.bookRepo = bookRepo;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String register() {
        return "register";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String registerProcess(Model model, @ModelAttribute @Valid User user, Errors errors) {

        if (errors.hasErrors()) {
            model.addAttribute("error", "Wprowadź prawidłowe dane w formularzu !!!");
            return "register";
        } else {
            List<Book> allBooks = bookRepo.findAll();
            userRepo.save(user);

            model.addAttribute("user", user);
            model.addAttribute("books", allBooks);
            return "userPanel";
        }
    }
}
