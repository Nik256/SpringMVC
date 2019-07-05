package com.epam.mvc.dto;

import lombok.*;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@ToString
public class Product {
    private int id;
    private String name;
    private String description;
}
