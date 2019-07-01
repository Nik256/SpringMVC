package com.epam.mvc.repository;

import com.epam.mvc.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomUserRepository implements UserRepository {
    private List<User> userList = new ArrayList<>();

    @Override
    public void create(User user) {
        userList.add(user);
    }

    @Override
    public User read(int id) {
        return userList.get(id);
    }

    @Override
    public List<User> getAll() {
        return userList;
    }
}
