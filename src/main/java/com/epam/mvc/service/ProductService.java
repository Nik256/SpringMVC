package com.epam.mvc.service;

import com.epam.mvc.model.Product;

import java.util.List;

public interface ProductService {
    void createProduct(Product product);

    Product getProduct(int id);

    void updateProduct(Product product);

    void deleteProduct(int id);

    List<Product> getAllProduct();
}
