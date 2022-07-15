package com.awbd.AWBD_books.services;

import com.awbd.AWBD_books.domain.Book;
import com.awbd.AWBD_books.domain.Category;
import com.awbd.AWBD_books.exceptions.ResourceNotFoundException;
import com.awbd.AWBD_books.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;


@Service
public class BookServiceImpl implements BookService {

    BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> findAll(){
        List<Book> books = new LinkedList<>();
        bookRepository.findAll().iterator().forEachRemaining(books::add);
        return books;
    }

    @Override
    public Book findById(Long l) {
        Optional<Book> productOptional = bookRepository.findById(l);
        if (!productOptional.isPresent()) {
            throw new ResourceNotFoundException("product " + l + " not found");
        }
        return productOptional.get();
    }

    @Override
    public Book save(Book book) {
        Book savedBook = bookRepository.save(book);
        return savedBook;
    }

    @Override
    public void deleteById(Long id) {
        Optional<Book> productOptional = bookRepository.findById(id);
        if (!productOptional.isPresent()) {
            throw new RuntimeException("Product not found!");
        }
        Book book = productOptional.get();
        List<Category> categories = new LinkedList<Category>();
        book.getCategories().iterator().forEachRemaining(categories::add);

        for (Category category: categories
                ) {
            book.removeCategory(category);
        }

        bookRepository.save(book);
        bookRepository.deleteById(id);

    }

}
