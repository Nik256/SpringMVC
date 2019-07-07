package com.epam.mvc.service;

import com.epam.mvc.dto.Product;
import com.epam.mvc.exception.AchievedMaxNumberOfRequestsException;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {
    void createProduct(Product product) throws AchievedMaxNumberOfRequestsException;

    Product getProduct(long id);

    void updateProduct(Product product);

    void deleteProduct(long id);

    List<Product> getAllProduct();

    List<Product> getProductsByName(String name);

    Page<Product> getAllProductsPage(int page);
}
