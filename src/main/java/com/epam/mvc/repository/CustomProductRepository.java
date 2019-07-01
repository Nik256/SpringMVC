package com.epam.mvc.repository;

import com.epam.mvc.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomProductRepository implements ProductRepository {
    private List<Product> productList = new ArrayList<>();

    @Override
    public void create(Product product) {
        productList.add(product);
    }

    @Override
    public Product read(int id) {
        return productList.get(id);
    }

    @Override
    public void update(Product product) {
        productList.set(productList.indexOf(product), product);
    }

    @Override
    public void delete(int id) {
        productList.remove(id);
    }

    @Override
    public List<Product> getAll() {
        return productList;
    }
}
