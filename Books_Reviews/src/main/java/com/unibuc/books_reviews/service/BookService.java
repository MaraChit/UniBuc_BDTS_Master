package com.unibuc.books_reviews.service;

import com.unibuc.books_reviews.dto.BookTopDTO;
import com.unibuc.books_reviews.model.Address;
import com.unibuc.books_reviews.model.Book;
import com.unibuc.books_reviews.repository.BookRepository;
import org.javatuples.Pair;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) { this.bookRepository = bookRepository; }

    public Book save (Book book) {return bookRepository.save(book);}

    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    public List<BookTopDTO> getTop3Books () {
        System.out.println(bookRepository.findTopThreeBooks());
        return bookRepository.findTopThreeBooks();}
}
