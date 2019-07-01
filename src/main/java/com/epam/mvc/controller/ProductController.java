package com.epam.mvc.controller;

import com.epam.mvc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("home")
    String index() {
        return "home";
    }

    @GetMapping("products")
    ModelAndView products() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/products");
        modelAndView.addObject("productList", productService.getAllProduct());
        return modelAndView;
    }

    @GetMapping("product/{id}")
    String products(@PathVariable int id) {
        return "product " + id;
    }
}
