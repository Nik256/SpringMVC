package com.epam.mvc.service;

import com.epam.mvc.dto.Product;
import com.epam.mvc.exception.AchievedMaxNumberOfRequestsException;
import com.epam.mvc.repository.ProductRepository;
import com.epam.mvc.session.RequestCounter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CustomProductService implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private RequestCounter requestCounter;

    @Value("${pageSize}")
    private int pageSize;

    @Override
    public void createProduct(Product product) throws AchievedMaxNumberOfRequestsException {
        if (requestCounter.isRequestAvailable()) {
            productRepository.save(product);
            requestCounter.reduceRequestNumber();
        } else {
            throw new AchievedMaxNumberOfRequestsException("Max number of requests achieved");
        }
    }

    @Override
    public Product getProduct(long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public void updateProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public void deleteProduct(long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> getAllProduct() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public Page<Product> getAllProductsPage(int page) {
        return productRepository.findAll(PageRequest.of(page, pageSize));
    }

    @Override
    public List<Product> getProductsByName(String name) {
        return StreamSupport.stream(productRepository.findAll().spliterator(), false)
                .filter(product -> product.getName().contains(name))
                .collect(Collectors.toList());
    }
}
