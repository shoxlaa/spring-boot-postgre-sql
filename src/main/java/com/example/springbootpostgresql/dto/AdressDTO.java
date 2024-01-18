package com.example.springbootpostgresql.dto;

import com.example.springbootpostgresql.entity.User;

public class AdressDTO {
    private long Id;
    private String Adress;
    private AdressType AdressType;
    private boolean Active;
    private User user;

    enum AdressType {
        Home,
        Work,
        Other
    }
}
