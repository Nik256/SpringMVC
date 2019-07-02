package com.epam.mvc.service;

import com.epam.mvc.exception.ProductNotFoundException;
import com.epam.mvc.model.Product;
import com.epam.mvc.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomProductService implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public void createProduct(Product product) {
        productRepository.create(product);
    }

    @Override
    public Product getProduct(int id) {
        return productRepository.read(id);
    }

    @Override
    public void updateProduct(Product product) {
        productRepository.update(product);
    }

    @Override
    public void deleteProduct(int id) {
        productRepository.delete(id);
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.getAll();
    }

    @Override
    public List<Product> getProductsByName(String name) {
        return productRepository.getAll().stream()
                .filter(product -> product.getName().contains(name))
                .collect(Collectors.toList());
    }
}
