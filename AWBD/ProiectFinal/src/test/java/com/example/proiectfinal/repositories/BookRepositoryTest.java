package com.example.proiectfinal.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.proiectfinal.model.Book;
import com.example.proiectfinal.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@Slf4j
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BookRepositoryTest {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void TestAddBooks()
    {
        Book book = new Book();
        book.setTitle("Farm Animals");
        book.setPublishingDate("12.11.1999");
        book.setRating(4.5f);

        Book savedBook = bookRepository.save(book);

        Book existingBook = testEntityManager.find(Book.class, savedBook.getBookId());

        log.info("test add book in book repository ...");
        assertThat(existingBook.getTitle()).isEqualTo(book.getTitle());
    }

   @Test
    public void TestUpdateBook()
    {
        long id = 1;
        Book book = new Book();
        book.setTitle("Game of Thrones");
        book.setPublishingDate("11.11.2005");
        book.setRating(4.9f);

        Book updatedBook = bookRepository.findByBookId(id);
        updatedBook.setTitle(book.getTitle());
        updatedBook.setPublishingDate(book.getPublishingDate());
        updatedBook.setRating(book.getRating());

        bookRepository.save(updatedBook);

        log.info("test update book in book repository ...");
        assertThat(updatedBook.getTitle()).isEqualTo(book.getTitle());
    }

}
