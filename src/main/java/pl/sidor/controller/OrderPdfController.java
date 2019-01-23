package pl.sidor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pl.sidor.service.CartService;

@Controller
public class OrderPdfController {

    private CartService cartService;

    @Autowired
    public OrderPdfController(CartService cartService) {
        this.cartService = cartService;
    }

    @RequestMapping(value = "/users.pdf", method = RequestMethod.GET)
    public String userDetails(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("orderPDF");

        model.addAttribute("books", cartService.findAll());

        return "orderPDF";
    }
}
