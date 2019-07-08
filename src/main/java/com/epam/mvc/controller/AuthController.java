package com.epam.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AuthController {
    @GetMapping("/")
    private ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:home");
        return modelAndView;
    }

    @GetMapping("home")
    private ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/home");
        return modelAndView;
    }

    @GetMapping("login")
    private ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/login");
        return modelAndView;
    }

    @GetMapping("logout")
    private ModelAndView logout(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:login");
        request.getSession().invalidate();
        return modelAndView;
    }
}
