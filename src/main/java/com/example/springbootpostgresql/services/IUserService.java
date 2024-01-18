package com.example.springbootpostgresql.services;

import com.example.springbootpostgresql.dto.UserDTO;
import com.example.springbootpostgresql.entity.User;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.List;


public interface IUserService {
    UserDTO save(UserDTO userDto);

    void delete(Long Id);

    List<UserDTO> getAll();

    Page<UserDTO> getAll(Pageable pageable);
}

