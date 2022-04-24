package com.example.emt.config;

import com.example.emt.model.Author;
import com.example.emt.model.Country;
import com.example.emt.model.dto.AuthorDto;
import com.example.emt.model.dto.BookDto;
import com.example.emt.model.dto.CountryDto;
import com.example.emt.model.enumerations.Category;
import com.example.emt.service.AuthorService;
import com.example.emt.service.BookService;
import com.example.emt.service.CategoryService;
import com.example.emt.service.CountryService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Component
public class DataInitializer {

    private final BookService bookService;
    private final CategoryService categoryService;
    private final CountryService countryService;
    private final AuthorService authorService;

    public DataInitializer(BookService bookService, CategoryService categoryService, CountryService countryService, AuthorService authorService) {
        this.bookService = bookService;
        this.categoryService = categoryService;
        this.countryService = countryService;
        this.authorService = authorService;
    }

    public void createCountries() {
        for(String item: Arrays.asList("Test", "Test1", "Test2")) {
            if (!this.countryService.doesCountryExist(item)) {
                CountryDto countryDto = new CountryDto();
                countryDto.setName(item);
                countryDto.setContinent(item);
                this.countryService.createCountry(countryDto);
            }
        }
    }

    public void createAuthors() {
        for(Country country: this.countryService.listCountries()) {
            for(String item: Arrays.asList("Test", "Test1", "Test2")) {
                if (!this.authorService.doesAuthorExist(item)) {
                    AuthorDto authorDto = new AuthorDto(item, item, country);
                    this.authorService.createAuthor(authorDto);
                }
            }
        }
    }

    public void createBooks() {
        for(Author author: this.authorService.listAuthors()) {
            for(Category category: this.categoryService.listCategories()) {
                if(!this.bookService.doesBookExist(author)) {
                    BookDto bookDto = new BookDto(category, "Test", 2, author);
                    this.bookService.createBook(bookDto);
                }
            }
        }
    }

    @PostConstruct
    public void initData() {
        createCountries();
        createAuthors();
        createBooks();
    }
}
