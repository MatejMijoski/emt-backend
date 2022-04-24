package com.example.emt.model;
import com.example.emt.model.enumerations.Category;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Data
@Entity
@Getter
@Setter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Category category;

    @Column
    private String name;

    @Column
    private Integer availableCopies;

    @ManyToOne
    private Author author;
}
