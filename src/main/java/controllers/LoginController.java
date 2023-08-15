package controllers;

import models.Admin;
import models.Buyer;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

@Controller
public class LoginController {
    @GetMapping("/login")
    public ModelAndView create() throws ClassNotFoundException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("buyer", new Buyer());
        modelAndView.addObject("buyers", Buyer.getAllBuyers());
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @PostMapping("/login")
    public ModelAndView validate(@ModelAttribute("buyer") Buyer buyer, @ModelAttribute("admin") Admin admin) throws ClassNotFoundException {
        ModelAndView modelAndView = new ModelAndView();
        Map<String, String> map = buyer.getKeys();
        boolean buyerValid = buyer.validate(map);
        boolean adminValid = admin.check();
        if (buyerValid) modelAndView.setViewName("sales");
        else if (adminValid) modelAndView.setViewName("admin");
        else modelAndView.setViewName("login");
        return modelAndView;
    }
}
