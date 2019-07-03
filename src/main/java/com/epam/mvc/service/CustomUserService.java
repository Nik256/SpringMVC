package com.epam.mvc.service;

import com.epam.mvc.model.User;
import com.epam.mvc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomUserService implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public void createUser(User user) {
        userRepository.create(user);
    }

    @Override
    public User getUser(int id) {
        return userRepository.read(id);
    }

    @Override
    public User getUserByName(String name) {
        return userRepository.getByName(name);
    }

    @Override
    public void deleteUser(int id) {
        userRepository.delete(id);
    }

    @Override
    public List<User> getAll() {
        return userRepository.getAll();
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
}
