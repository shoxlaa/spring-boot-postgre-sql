package com.example.springbootpostgresql.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "user-adress")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@ToString
public class Adress implements Serializable {
    @Id
    @SequenceGenerator(name = "seq_user_adress", allocationSize = 1)
    @GeneratedValue(generator = "seq_user_adress", strategy = GenerationType.SEQUENCE)
    private long Id;
    @Column(length = 500, name = "adress")
    private String Adress;
    @Enumerated
    private AdressType AdressType;
    @Column(name = "adress")
    private boolean Active;
    @ManyToOne()
    @JoinColumn(name = "user_adress_id")
    private  User user;
    public enum AdressType {
        Home,
        Work,
        Other
    }
}
