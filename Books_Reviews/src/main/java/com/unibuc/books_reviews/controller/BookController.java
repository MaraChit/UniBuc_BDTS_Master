package com.unibuc.books_reviews.controller;

import com.unibuc.books_reviews.dto.BookTopDTO;
import com.unibuc.books_reviews.model.Book;
import com.unibuc.books_reviews.service.BookService;
import org.javatuples.Pair;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) { this.bookService = bookService; }

    @PostMapping("/new")
    public ResponseEntity<Book> saveBook(@RequestBody @Valid Book book){
        return ResponseEntity.ok()
                .body(bookService.save(book));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Book>> retrieveBooks() {
        return ResponseEntity.ok().body(bookService.getAll());
    }

    @GetMapping("/getTop3")
    public ResponseEntity<List<BookTopDTO>> retrieveTop3Books() {
        return ResponseEntity.ok().body(bookService.getTop3Books());
    }


}
