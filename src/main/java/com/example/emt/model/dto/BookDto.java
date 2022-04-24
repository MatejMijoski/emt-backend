package com.example.emt.model.dto;

import com.example.emt.model.Author;
import com.example.emt.model.enumerations.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookDto {
    @Nullable
    private Long id;

    @Enumerated(EnumType.STRING)
    private Category category;

    private String name;

    @Nullable
    private Integer availableCopies;

    @Nullable
    private Author author;

    public BookDto(Category category, String name, Integer availableCopies, Author author) {
        this.category = category;
        this.name = name;
        this.availableCopies = availableCopies;
        this.author = author;
    }
}
