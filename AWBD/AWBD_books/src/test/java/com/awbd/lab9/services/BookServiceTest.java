//package com.awbd.lab9.services;
//
//import com.awbd.lab9.domain.Book;
//import com.awbd.lab9.repositories.BookRepository;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.*;
//
//@ExtendWith(MockitoExtension.class)
//public class BookServiceTest {
//
//    /*
//    @BeforeEach
//    public void setUp() throws Exception {
//        productService = new ProductServiceImpl(productRepository);
//    }
//    */
//
//    @Mock
//    BookRepository bookRepository;
//
//    @InjectMocks
//    BookServiceImpl productService;
//
//    @Test
//    public void findProducts() {
//        List<Book> productsRet = new ArrayList<Book>();
//        Book book = new Book();
//        book.setId(4L);
//        book.setCode("TEST");
//        productsRet.add(book);
//
//        when(bookRepository.findAll()).thenReturn(productsRet);
//        List<Book> books = productService.findAll();
//        assertEquals(books.size(), 1);
//        verify(bookRepository, times(1)).findAll();
//    }
//
//
//}
