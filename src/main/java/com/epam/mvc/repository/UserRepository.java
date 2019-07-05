package com.epam.mvc.repository;

import com.epam.mvc.dto.User;

import java.util.List;

public interface UserRepository {
    void create(User user);

    User read(int id);

    List<User> getAll();

    User getByName(String name);

    void delete(int id);

    User getById(int id);
}
