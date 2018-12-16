package pl.sidor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.sidor.dao.UserRepo;
import pl.sidor.daoImpl.BookDAOImpl;
import pl.sidor.model.User;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Controller
public class UserController {


    @Autowired
    @Qualifier("userRepository")
    private UserRepo userRepo;
    @Autowired
    private BookDAOImpl bookDAO;


    @RequestMapping("find")
    public String find(Model model) {


        model.addAttribute("books", bookDAO.getAllBook());

        return "userPanel";
    }


}
