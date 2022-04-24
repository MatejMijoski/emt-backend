package com.example.emt.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column()
    private String name;

    @Column()
    private String surname;

    @ManyToOne
    private Country country;

}
