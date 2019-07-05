package com.epam.mvc.repository;

import com.epam.mvc.dto.UserJPA;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "uzer", path = "uzer")
public interface UserRepositoryJPA extends PagingAndSortingRepository<UserJPA, Long> {

    List<UserJPA> findByName(@Param("name") String name);
}
