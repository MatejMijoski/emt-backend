package com.example.emt.service;

import com.example.emt.model.Author;
import com.example.emt.model.dto.AuthorDto;
import com.example.emt.repository.AuthorRepository;
import com.example.emt.repository.CountryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;

    public AuthorService(AuthorRepository authorRepository, CountryRepository countryRepository) {
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
    }

    public List<Author> listAuthors() {
        return this.authorRepository.findAll();
    }

    public Boolean doesAuthorExist(String name) {
        return this.authorRepository.findByName(name).isPresent();
    }

    public Author createAuthor(AuthorDto authorDto) {
        Author author = new Author();
        author.setName(authorDto.getName());
        author.setSurname(authorDto.getSurname());
        author.setCountry(this.countryRepository.getById(authorDto.getCountry().getId()));
        return this.authorRepository.save(author);
    }
}
