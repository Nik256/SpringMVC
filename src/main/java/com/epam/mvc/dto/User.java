package com.epam.mvc.dto;

import lombok.*;

import javax.persistence.*;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@ToString
@Entity(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
}
