package com.epam.mvc.repository;

import com.epam.mvc.dto.Product;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Integer> {
    Product findByName(String name);
}
