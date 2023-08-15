package controllers;

import models.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class ProductController {

    @GetMapping("/products")
    public ModelAndView create() throws ClassNotFoundException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("product", new Product());
        modelAndView.addObject("products", Product.getAll());
        modelAndView.setViewName("products");
        return modelAndView;
    }
    @PostMapping("/products")
    public ModelAndView update(@ModelAttribute("product") Product product) throws ClassNotFoundException {
        return create();
    }
}
