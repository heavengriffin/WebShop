package controllers;

import models.Product;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class InsertProductController {

    @GetMapping("/insert_product")
    public ModelAndView create3() throws ClassNotFoundException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("product", new Product());
        modelAndView.addObject("products", Product.getAll());
        modelAndView.setViewName("insert_product");
        return modelAndView;
    }
    @PostMapping("/insert_product")
    public ModelAndView insertProduct(@ModelAttribute("product") @Valid Product product, BindingResult result) throws ClassNotFoundException {
        ModelAndView modelAndView = new ModelAndView();

        if (result.hasErrors()) {
            modelAndView.setViewName("insert_product");
            return modelAndView;
        }

            int inserted = product.insertProduct();
            if (inserted == 1)
                modelAndView.setViewName("successfully_inserted_product");
            else modelAndView.setViewName("insert_product");
            return modelAndView;


    }
}
