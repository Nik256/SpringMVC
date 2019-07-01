package com.epam.mvc.service;

import com.epam.mvc.model.User;

public interface UserService {
    void createUser(User user);

    void getUser(int id);

    boolean isUserExist(String userName);
}
