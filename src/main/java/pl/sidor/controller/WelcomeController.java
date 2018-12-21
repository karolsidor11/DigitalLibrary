package pl.sidor.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import pl.sidor.dao.UserDao;
import pl.sidor.model.User;

@Controller
public class WelcomeController {

    private static final Logger logger = LoggerFactory.getLogger(WelcomeController.class);

    private final UserDao userDao;

    @Autowired
    public WelcomeController(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping(value = "/")
    public String home() {

        return "home";

    }

    @GetMapping(value = "/find")
    public String welcome(Model model) {

        List<User> users = userDao.findAll();


        model.addAttribute("user", users);

        return "welcome";

    }

}