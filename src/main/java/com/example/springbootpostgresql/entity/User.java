package com.example.springbootpostgresql.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@ToString
public class User {
    @Id
    @SequenceGenerator(name = "seq_user_adress", allocationSize = 1)
    @GeneratedValue(generator = "seq_user_adress", strategy = GenerationType.SEQUENCE)
    private long Id;
    @Column(length = 500, name = "adress")
    private String Name;
    @Column(length = 100, name = "adress")
    private String Lastname;

    @OneToMany
    @JoinColumn(name = "user_adress_id")
    List<Adress> Adresses;

}
