package com.example.proiectfinal.repository;

import com.example.proiectfinal.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Override
    List<Book> findAll();

    @Query("SELECT b FROM Book b WHERE b.title = ?1")
    List<Book> findByTitle(String title);

    @Query("SELECT b FROM Book b WHERE b.bookId = ?1")
    Optional<Book> findById(Long id);

    @Query("SELECT b FROM Book b WHERE b.bookId = ?1")
    Book findByBookId(Long id);
}

