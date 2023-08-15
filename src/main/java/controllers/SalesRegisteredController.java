package controllers;

import models.Sale;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SalesRegisteredController {
    @GetMapping("/sales_registered")
    public ModelAndView create() throws ClassNotFoundException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("sale", new Sale());
        modelAndView.addObject("sales", Sale.getAll());
        modelAndView.setViewName("sales_registered");
        return modelAndView;
    }
    @PostMapping("/sales_registered")
    public ModelAndView update(@ModelAttribute("sale") Sale sale) throws ClassNotFoundException {

        return create();
    }
}
