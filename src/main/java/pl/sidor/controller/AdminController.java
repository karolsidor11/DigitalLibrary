package pl.sidor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @GetMapping(value = "/addBook")
    public String addBook(Model model) {

        model.addAttribute("info", "Książka została dodana do bazy danych !!!");
        return "manageBooks";

    }
}
