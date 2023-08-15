package controllers;

import models.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {

    @GetMapping("/admin")
    public ModelAndView create2() throws ClassNotFoundException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("product", new Product());
        modelAndView.addObject("products", Product.getAll());
        modelAndView.setViewName("admin");
        return modelAndView;
    }
    @PostMapping("/admin")
    public ModelAndView process(@ModelAttribute("product") Product product) throws ClassNotFoundException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin");
        return modelAndView;
    }
}
