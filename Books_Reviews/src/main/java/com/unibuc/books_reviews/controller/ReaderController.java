package com.unibuc.books_reviews.controller;

import com.unibuc.books_reviews.model.Reader;
import com.unibuc.books_reviews.service.ReaderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reader")
public class ReaderController {
    private final ReaderService readerService;

    public ReaderController(ReaderService readerService) { this.readerService = readerService;}
    @PostMapping("/new")
    public ResponseEntity<Reader> saveReader(@RequestBody Reader reader){
        return ResponseEntity.ok()
                .body(readerService.save(reader));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Reader>> retrieveReaders() {
        return ResponseEntity.ok().body(readerService.getAll());
    }
}
