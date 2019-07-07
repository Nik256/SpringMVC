package com.epam.mvc.repository;

import com.epam.mvc.dto.Product;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "resource", path = "resource")
public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {
    Product findByName(@Param("name") String name);
}
