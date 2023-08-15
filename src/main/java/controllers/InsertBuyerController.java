package controllers;

import models.Buyer;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class InsertBuyerController {
    @GetMapping("/insert_buyer")
    public ModelAndView create() throws ClassNotFoundException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("buyer", new Buyer());
        modelAndView.addObject("buyers", Buyer.getAllBuyers());
        modelAndView.setViewName("insert_buyer");
        return modelAndView;
    }

    @PostMapping("/insert_buyer")
    public ModelAndView process(@ModelAttribute @Valid Buyer buyer, BindingResult result) throws ClassNotFoundException {
        ModelAndView modelAndView = new ModelAndView();

        if (result.hasErrors()) {
            modelAndView.setViewName("insert_buyer");
            return modelAndView;
        }

        int inserted = buyer.insertBuyer();
        if (inserted == 1)
            modelAndView.setViewName("successfully_inserted_buyer");
        else modelAndView.setViewName("insert_buyer");
        return modelAndView;
    }
}
