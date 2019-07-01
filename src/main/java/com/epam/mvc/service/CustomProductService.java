package com.epam.mvc.service;

import com.epam.mvc.model.Product;
import com.epam.mvc.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

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

    @PostConstruct
    private void initSomeProduct() {
        productRepository.create(new Product(1, "Green leaf", "Leaf from old oak"));
        productRepository.create(new Product(2, "Some orange", "Vitamin C is all what you need"));
        productRepository.create(new Product(3, "Tea cup", "Cup to drink green tea"));
    }
}
