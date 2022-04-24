package com.example.emt.repository;

import com.example.emt.model.Author;
import com.example.emt.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findByAuthor(Author author);
    Optional<Book> getBookById(Long id);
}
