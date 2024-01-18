package com.example.springbootpostgresql.repo;

import com.example.springbootpostgresql.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long> {

}

