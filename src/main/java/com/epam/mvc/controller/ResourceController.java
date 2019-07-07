package com.epam.mvc.controller;

import com.epam.mvc.dto.Product;
import com.epam.mvc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ResourceController {
    @Autowired
    ProductService productService;

    @GetMapping("/product/{id}")
    public Product getProductById(@PathVariable long id) {
        return productService.getProduct(id);
    }

    @GetMapping("/product")
    public List<Product> getProductList(@RequestParam(required = false) Integer page) {
        if (page == null) {
            return productService.getAllProduct();
        }
        return productService.getAllProductsPage(page).getContent();
    }

    @GetMapping("/product/search")
    public List<Product> findByNameProduct(@RequestParam String name) {
        return productService.getProductsByName(name);
    }

    @PostMapping("/product")
    public ResponseEntity<Object> createProduct(@RequestBody Product product) {
        productService.createProduct(product);
        return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
    }

    @PutMapping(value = "/product/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable("id") long id, @RequestBody Product product) {
        product.setId(id);
        productService.updateProduct(product);
        return new ResponseEntity<>("Product is updated successfully", HttpStatus.OK);
    }

    @DeleteMapping(value = "/product/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") long id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>("Product is deleted successfully", HttpStatus.OK);
    }
}
