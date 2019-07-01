package com.epam.mvc.repository;

import com.epam.mvc.model.Product;

import java.util.List;

public interface ProductRepository {
    void create(Product product);

    Product read(int id);

    void update(Product product);

    void delete(int id);

    List<Product> getAll();
}
