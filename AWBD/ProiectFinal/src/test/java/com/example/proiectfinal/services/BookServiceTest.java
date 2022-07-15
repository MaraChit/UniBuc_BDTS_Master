package com.example.proiectfinal.services;

import com.example.proiectfinal.model.Book;
import com.example.proiectfinal.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BookServiceTest {
    @Autowired
    private BookRepository bookRepository;

    @Test
    public void findBookByTitle() {
        List<Book> books = bookRepository.findByTitle("Harry Potter and The Goblet Of Fire");
        assertTrue(books.size() >= 1);
        log.info("Find book by title ...");
        books.forEach(product -> log.info(product.getTitle()));
    }

    @Test
    public void findPage(){
        Pageable firstPage = PageRequest.of(0, 3);
        Page<Book> allBooks = bookRepository.findAll(firstPage);
        log.info("Find page ...");
        assertTrue(allBooks.getNumberOfElements() == 3);
    }


}
