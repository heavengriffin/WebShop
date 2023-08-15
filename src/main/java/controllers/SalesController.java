package controllers;

import models.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SalesController {

    @GetMapping("/sales")
    public ModelAndView create() throws ClassNotFoundException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("product", new Product());
        modelAndView.addObject("products", Product.getAll());
        modelAndView.setViewName("sales");
        return modelAndView;
    }
    @PostMapping("/sales")
    public ModelAndView update(@ModelAttribute("product") Product product) throws ClassNotFoundException {
        return create();
    }
}
