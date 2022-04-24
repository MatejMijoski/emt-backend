package com.example.emt.model.dto;

import com.example.emt.model.Country;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.lang.Nullable;

@AllArgsConstructor
@Data
public class AuthorDto {

    private Long id;

    private String name;

    private String surname;

    private Country country;

    public AuthorDto(String name, String surname, Country country) {
        this.name = name;
        this.surname = surname;
        this.country = country;
    }
}
