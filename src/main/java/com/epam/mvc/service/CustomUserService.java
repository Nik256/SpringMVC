package com.epam.mvc.service;

import com.epam.mvc.model.Role;
import com.epam.mvc.model.User;
import com.epam.mvc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class CustomUserService implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public void createUser(User user) {
        userRepository.create(user);
    }

    @Override
    public void getUser(int id) {
        userRepository.read(id);
    }

    @Override
    public boolean isUserExist(String userName) {
        for (User user : userRepository.getAll()) {
            if (user.getName().equals(userName)) {
                return true;
            }
        }
        return false;
    }

    @PostConstruct
    public void initSomeUsers() {
        userRepository.create(new User(1, "user", "pass", Role.USER));
        userRepository.create(new User(2, "admin", "admin", Role.ADMIN));
    }
}
