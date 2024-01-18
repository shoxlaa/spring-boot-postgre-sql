package com.example.springbootpostgresql.dto;

import lombok.Data;

import java.util.List;
@Data
public class UserDTO {
    private  Long Id;
    private  String Name;
    private  String Lastname;
    private List<String> Adresses;
}

