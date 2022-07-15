//package com.awbd.lab9.repositories;
//
//import com.awbd.AWBD_books.repositories.BookRepository;
//import com.awbd.lab9.domain.Book;
//import lombok.extern.slf4j.Slf4j;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.test.annotation.Rollback;
//import org.springframework.test.context.ActiveProfiles;
//
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@ActiveProfiles("mysql")
//@Rollback(false)
//@Slf4j
//public class BookRepositoryTest {
//
//    @Autowired
//    private BookRepository bookRepository;
//
//    @Test
//    public void findProducts() {
//        List<Book> books = bookRepository.findBySeller(1L);
//        assertTrue(books.size() >= 1);
//        log.info("findBySeller ...");
//        books.forEach(product -> log.info(product.getTitle()));
//    }
//
//    @Test
//    public void findProductsBySellerName() {
//        List<Book> books = bookRepository.findBySellerName("Will","Snow");
//        assertTrue(books.size() >= 1);
//        log.info("findBySeller ...");
//        books.forEach(product -> log.info(product.getTitle()));
//    }
//
//    @Test
//    public void findPage(){
//        Pageable firstPage = PageRequest.of(0, 2);
//        Page<Book> allProducts = bookRepository.findAll(firstPage);
//        assertTrue(allProducts.getNumberOfElements() == 2);
//    }
//
//
//
//}
