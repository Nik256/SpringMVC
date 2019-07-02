package com.epam.mvc.repository;

import com.epam.mvc.model.Role;
import com.epam.mvc.model.User;
import com.github.javafaker.Faker;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.IntStream;

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

    @Override
    public User getByName(String name) {
        for (User user: userList) {
            if (user.getName().equals(name)) {
                return user;
            }
        }
        return null;
    }

    @PostConstruct
    public void initSomeUsers() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        create(new User(0, "user", encoder.encode("pass"),
                new HashSet<>(Arrays.asList(Role.USER))));
        create(new User(1, "admin", encoder.encode("admin"),
                new HashSet<>(Arrays.asList(Role.USER, Role.ADMIN))));
        Faker faker = new Faker();
        IntStream.range(2, 10).forEach(i -> userList.add(new User(i,
                faker.name().username(),
                encoder.encode(faker.funnyName().name()),
                new HashSet<>(Arrays.asList(Role.USER)))));
    }
}
