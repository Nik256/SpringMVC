package com.epam.mvc.repository;

import com.epam.mvc.model.Role;
import com.epam.mvc.model.User;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.IntStream;

@Repository
public class CustomUserRepository implements UserRepository {
    private List<User> userList = Collections.synchronizedList(new ArrayList<>());

    @Value("${initialUserCount}")
    private int initialUserCount;

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

    @Override
    public User getByName(String name) {
        for (User user: userList) {
            if (user.getName().equals(name)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public void delete(int id) {
        userList.remove(getById(id));
    }

    @Override
    public User getById(int id) {
        return userList.stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @PostConstruct
    public void initSomeUsers() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        create(new User(0, "user", encoder.encode("pass"),
                new HashSet<>(Arrays.asList(Role.USER))));
        create(new User(1, "admin", encoder.encode("admin"),
                new HashSet<>(Arrays.asList(Role.USER, Role.ADMIN))));
        Faker faker = new Faker();
        IntStream.range(2, initialUserCount).forEach(i -> userList.add(new User(i,
                faker.name().username(),
                encoder.encode(faker.funnyName().name()),
                new HashSet<>(Arrays.asList(Role.USER)))));
    }
}
