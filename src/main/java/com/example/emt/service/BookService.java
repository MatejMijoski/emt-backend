package com.example.emt.service;

import com.example.emt.model.Author;
import com.example.emt.model.Book;
import com.example.emt.model.dto.BookDto;
import com.example.emt.model.exceptions.BookNotFoundException;
import com.example.emt.model.exceptions.NoAvailableCopiesException;
import com.example.emt.repository.AuthorRepository;
import com.example.emt.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public Book createBook(BookDto bookDto) {
        Book book = new Book();
        book.setName(bookDto.getName());
        book.setCategory(bookDto.getCategory());
        book.setAuthor(this.authorRepository.getById(bookDto.getAuthor().getId()));
        book.setAvailableCopies(bookDto.getAvailableCopies());
        return this.bookRepository.save(book);
    }

    public List<Book> listBooks() {
        return this.bookRepository.findAll();
    }

    public Book editBook(Long id, BookDto bookDto) {
        Optional<Book> book = bookRepository.getBookById(id);
        if (book.isPresent()) {
            Book book1 = book.get();
            book1.setName(bookDto.getName());
            book1.setCategory(bookDto.getCategory());
            return bookRepository.save(book1);
        } else throw new BookNotFoundException(id);
    }

    public Boolean doesBookExist(Author author) {
        return this.bookRepository.findByAuthor(author).isPresent();
    }

    public void deleteBook(Long id) {
        this.bookRepository.deleteById(id);
    }

    public Book rentBook(Long id) throws NoAvailableCopiesException, BookNotFoundException {
        Optional<Book> book = bookRepository.getBookById(id);
        if (book.isPresent()) {
            if (book.get().getAvailableCopies() > 0) {
                book.get().setAvailableCopies(book.get().getAvailableCopies() - 1);
                return bookRepository.save(book.get());
            } else throw new NoAvailableCopiesException(id);
        } else throw new BookNotFoundException(id);
    }
 }
