package com.epam.mvc.controller;

import com.epam.mvc.model.Role;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AuthController {
    @GetMapping("/")
    private String index() {
        return "redirect:home";
    }

    @GetMapping("home")
    private ModelAndView home(Authentication authentication) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("username", authentication.getName());
        modelAndView.addObject("authorities", authentication.getAuthorities());
        if (authentication.getAuthorities().contains(new SimpleGrantedAuthority(Role.ADMIN.toString()))) {
            modelAndView.addObject("admin", true);
        }
        modelAndView.setViewName("/home");
        return modelAndView;
    }

    @GetMapping("login")
    private String login() {
        return "login";
    }

    @GetMapping("logout")
    private ModelAndView logout(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:login");
        request.getSession().invalidate();
        return modelAndView;
    }
}
