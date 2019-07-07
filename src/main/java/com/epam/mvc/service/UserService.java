package com.epam.mvc.service;

import com.epam.mvc.dto.User;

import java.util.List;

public interface UserService {
    void createUser(User user);

    User getUser(long id);

    User getUserByName(String name);

    void deleteUser(long id);

    List<User> getAll();
}
