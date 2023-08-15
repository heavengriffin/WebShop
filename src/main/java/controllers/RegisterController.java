package controllers;

import models.Buyer;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class RegisterController {

    @GetMapping("/register")
    public ModelAndView createNewBuyer() throws ClassNotFoundException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("buyer", new Buyer());
        modelAndView.addObject("buyers", Buyer.getAllBuyers());
        modelAndView.setViewName("register");
        return modelAndView;
    }

    @PostMapping("/register")
    public ModelAndView register(@ModelAttribute("buyer") @Valid Buyer buyer, BindingResult result) throws ClassNotFoundException {
        ModelAndView modelAndView = new ModelAndView();

        if (result.hasErrors()) {
            modelAndView.setViewName("register");
            return modelAndView;
        }

        buyer.insertBuyer();
        modelAndView.setViewName("successfully_registered");
        return modelAndView;
    }
}
