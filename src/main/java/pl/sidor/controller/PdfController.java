package pl.sidor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pl.sidor.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class PdfController {


    @RequestMapping(value = "/generate/pdf.htm", method = RequestMethod.GET)
    ModelAndView generatePdf(HttpServletRequest request, HttpServletResponse response) throws Exception {

        System.out.println("Calling generatePdf()...");

        User user = new User(1, "Karol", "karolsidor11@wp.pl", "Karol", "123");

        ModelAndView modelAndView = new ModelAndView("pdfView", "command",user );

        return modelAndView;
    }
}
