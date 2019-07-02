package com.epam.mvc.model;

import lombok.*;

import java.util.Set;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@ToString
public class User {
    private int id;
    private String name;
    private String password;
    private Set<Role> roles;
}
