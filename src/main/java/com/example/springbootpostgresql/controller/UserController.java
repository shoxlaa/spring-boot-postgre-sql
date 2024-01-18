package com.example.springbootpostgresql.controller;

import com.example.springbootpostgresql.dto.UserDTO;
import com.example.springbootpostgresql.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @PostMapping
    public ResponseEntity<UserDTO> add (@RequestBody UserDTO userDTO)
    {
        return  ResponseEntity.ok(userService.save(userDTO));
    }
    @GetMapping
    public ResponseEntity<List<UserDTO>> get(){

        return ResponseEntity.ok(userService.getAll());
    }
}
