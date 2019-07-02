package com.epam.mvc.repository;

import com.epam.mvc.exception.ProductNotFoundException;
import com.epam.mvc.model.Product;
import com.github.javafaker.Faker;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Repository
public class CustomProductRepository implements ProductRepository {
    private List<Product> productList = new ArrayList<>();

    @Override
    public void create(Product product) {
        product.setId(productList.size());
        productList.add(product);
    }

    @Override
    public Product read(int id) {
        return getById(id);
    }

    @Override
    public void update(Product product) {
        productList.set(product.getId(), product);
    }

    @Override
    public void delete(int id) {
        productList.remove(getById(id));
    }


    @Override
    public Product getById(int id) {
        return productList.stream().filter(product -> product.getId() == id).findFirst().get();
    }

    @Override
    public List<Product> getAll() {
        return productList;
    }

    @PostConstruct
    public void initSomeProducts() {
        Faker faker = new Faker();
        IntStream.range(0, 20).forEach(i -> productList.add(new Product(i,
                faker.book().title(),
                faker.book().genre() + " - " + faker.book().author())));
    }
}
