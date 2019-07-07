package com.epam.mvc.config;

import com.epam.mvc.handler.CustomAuthenticationSuccessHandler;
import com.epam.mvc.dto.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    private CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("SELECT name, password, true FROM user WHERE name = ?")
                .authoritiesByUsernameQuery("SELECT name, role FROM user WHERE name = ?")
                .passwordEncoder(new BCryptPasswordEncoder(10));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/error").permitAll()
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
