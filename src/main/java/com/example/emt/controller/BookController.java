package com.example.emt.controller;

import com.example.emt.model.Book;
import com.example.emt.model.dto.BookDto;
import com.example.emt.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getBooks() {
        return bookService.listBooks();
    }

    @PostMapping
    public Book createBook(@RequestBody BookDto bookDto) {
        return bookService.createBook(bookDto);
    }

    @PutMapping("/{id}")
    public Book editBoot(@PathVariable Long id, @RequestBody BookDto bookDto) {
        return bookService.editBook(id, bookDto);
    }

    @GetMapping("/{id}/rent")
    public Book rentBook(@PathVariable Long id) {
        return bookService.rentBook(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable Long id) {
        this.bookService.deleteBook(id);
        return ResponseEntity.status(204).build();
    }
}
