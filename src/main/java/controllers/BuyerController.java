package controllers;


import models.Admin;
import models.Buyer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


import java.util.Map;


@Controller
public class BuyerController {
    @GetMapping("/buyers")
    public ModelAndView create() throws ClassNotFoundException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("buyer", new Buyer());
        modelAndView.addObject("buyers", Buyer.getAllBuyers());
        modelAndView.setViewName("buyers");
        return modelAndView;
    }
    @PostMapping("/buyers")
    public ModelAndView process(@ModelAttribute Buyer buyer) throws ClassNotFoundException {
        return create();
    }
}


