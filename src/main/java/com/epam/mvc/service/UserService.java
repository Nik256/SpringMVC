package com.epam.mvc.service;

import com.epam.mvc.model.User;

import java.util.List;

public interface UserService {
    void createUser(User user);

    User getUser(int id);

    User getUserByName(String name);

    List<User> getAll();

    boolean isUserExist(String userName);
}
