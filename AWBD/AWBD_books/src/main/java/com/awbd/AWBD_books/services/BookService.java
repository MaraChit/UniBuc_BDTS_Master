package com.awbd.AWBD_books.services;

import com.awbd.AWBD_books.domain.Book;

import java.util.List;

public interface BookService {
    List<Book> findAll();
    Book findById(Long l);
    Book save(Book book);
    void deleteById(Long id);

}
