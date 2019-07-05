package com.epam.mvc.config;

import com.epam.mvc.handler.CustomAuthenticationSuccessHandler;
import com.epam.mvc.model.Role;
import com.epam.mvc.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;

    @Autowired
    CustomUserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers("/error").permitAll()
                    .antMatchers("/products", "/product/**").hasAuthority(Role.USER.toString())
                    .antMatchers("/users").hasAuthority(Role.ADMIN.toString())
                    .anyRequest().authenticated()
                .and()
                    .csrf().disable()
                    .formLogin()
                    .successHandler(customAuthenticationSuccessHandler)
                    .failureForwardUrl("/error")
                    .permitAll()
                .and()
                    .logout()
                    .permitAll();
    }
}
