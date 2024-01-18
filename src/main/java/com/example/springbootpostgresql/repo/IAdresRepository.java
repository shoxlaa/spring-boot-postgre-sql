package com.example.springbootpostgresql.repo;

import com.example.springbootpostgresql.entity.Adress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAdresRepository extends JpaRepository<Adress,Long> {
}
