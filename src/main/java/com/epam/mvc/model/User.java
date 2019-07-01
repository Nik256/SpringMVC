package com.epam.mvc.model;

import lombok.*;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@ToString
public class User {
    private int id;
    private String name;
    private String password;
    private Role role;
}
