package com.epam.mvc.controller;

import com.epam.mvc.dto.Role;
import com.epam.mvc.dto.User;
import com.epam.mvc.service.UserService;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.stream.IntStream;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("users")
    private ModelAndView users() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("users");
        modelAndView.addObject("userList", userService.getAll());
        return modelAndView;
    }

    @GetMapping("delete-user/{id}")
    private ModelAndView deleteUserById(@PathVariable int id) {
        userService.deleteUser(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/users");
        return modelAndView;
    }

    @GetMapping("generate-users")
    private void generateUsers() {
        Faker faker = new Faker();
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);
        IntStream.range(0, 10).forEach(i -> userService.createUser(new User(i,
                faker.name().username(),
                encoder.encode(faker.funnyName().name()),
                Role.USER)));
    }
}
