package com.epam.mvc.repository;

import com.epam.mvc.dto.Product;

import java.util.List;

public interface ProductRepository {
    void create(Product product);

    Product read(int id);

    void update(Product product);

    void delete(int id);

    Product getById(int id);

    List<Product> getAll();
}
