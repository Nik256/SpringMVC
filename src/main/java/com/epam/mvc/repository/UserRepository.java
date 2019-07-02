package com.epam.mvc.repository;

import com.epam.mvc.model.User;

import java.util.List;

public interface UserRepository {
    void create(User user);

    User read(int id);

    List<User> getAll();

    User getByName(String name);
}
