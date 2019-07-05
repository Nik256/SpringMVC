package com.epam.mvc.service;

import com.epam.mvc.dto.Product;
import com.epam.mvc.exception.AchievedMaxNumberOfRequestsException;
import com.epam.mvc.repository.ProductRepository;
import com.epam.mvc.session.RequestCounter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CustomProductService implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private RequestCounter sessionManager;

    @Override
    public void createProduct(Product product) throws AchievedMaxNumberOfRequestsException {
        if (sessionManager.isRequestAvailable()) {
            productRepository.save(product);
            sessionManager.reduceRequestNumber();
        } else {
            throw new AchievedMaxNumberOfRequestsException("Max number of requests achieved");
        }
    }

    @Override
    public Product getProduct(int id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public void updateProduct(Product product) {
        product = productRepository.findByName(product.getName());
        productRepository.save(product);
    }

    @Override
    public void deleteProduct(int id) {
        productRepository.delete(productRepository.findById(id).orElse(null));
    }

    @Override
    public List<Product> getAllProduct() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public List<Product> getProductsByName(String name) {
        return StreamSupport.stream(productRepository.findAll().spliterator(), false)
                .filter(product -> product.getName().contains(name))
                .collect(Collectors.toList());
    }
}
