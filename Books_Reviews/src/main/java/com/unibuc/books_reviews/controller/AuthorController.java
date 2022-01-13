package com.unibuc.books_reviews.controller;

import com.unibuc.books_reviews.model.Author;
import com.unibuc.books_reviews.service.AuthorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) { this.authorService = authorService; }

    @PostMapping("/new")
    public ResponseEntity<Author> saveAuthor(@RequestBody Author author){
        return ResponseEntity.ok()
                .body(authorService.save(author));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Author>> retrieveAuthors() {
        return ResponseEntity.ok().body(authorService.getAll());
    }


    @GetMapping("/authorByName")
    public ResponseEntity<Author> retrieveByName(@RequestParam String authorName){
        return ResponseEntity.ok().body(authorService.retrieveByName(authorName));
    }
}
