package com.epam.mvc.controller;

import com.epam.mvc.exception.AchievedMaxNumberOfRequestsException;
import com.epam.mvc.dto.Product;
import com.epam.mvc.service.PagingService;
import com.epam.mvc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private PagingService pagingService;

    @GetMapping("products")
    private ModelAndView products(@RequestParam(required = false) Integer page) {
        if (page == null) {
            page = 1;
        }
        pagingService.setCurrentPage(page);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/products");
        modelAndView.addObject("maxPages", pagingService.getPageCount());
        modelAndView.addObject("productList", pagingService.getPageList());
        modelAndView.addObject("page", page);
        return modelAndView;
    }

    @GetMapping("product/{id}")
    private ModelAndView productById(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/product");
        modelAndView.addObject("product", productService.getProduct(id));
        return modelAndView;
    }

    @GetMapping("product")
    private String product() {
        return "product";
    }

    @PostMapping("create-product")
    private ModelAndView createProduct(Product product) {
        ModelAndView modelAndView = new ModelAndView();
        try {
            productService.createProduct(product);
            modelAndView.setViewName("redirect:/products");
        } catch (AchievedMaxNumberOfRequestsException e) {
            modelAndView.addObject("error", e.getMessage());
            modelAndView.setViewName("/error");
        }
        return modelAndView;
    }

    @PostMapping("edit-product")
    private String editProduct(Product product) {
        productService.updateProduct(product);
        return "redirect:products";
    }

    @GetMapping("delete-product/{id}")
    private ModelAndView deleteProductById(@PathVariable int id) {
        productService.deleteProduct(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/products");
        return modelAndView;
    }

    @GetMapping("search")
    private String search() {
        return "search";
    }

    @PostMapping("search")
    private ModelAndView postSearch(@RequestParam(value = "name") String name) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/products");
        modelAndView.addObject("productList", productService.getProductsByName(name));
        return modelAndView;
    }
}
