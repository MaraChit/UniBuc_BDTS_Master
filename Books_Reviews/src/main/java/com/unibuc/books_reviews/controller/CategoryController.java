package com.unibuc.books_reviews.controller;

import com.unibuc.books_reviews.model.Category;
import com.unibuc.books_reviews.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) { this.categoryService = categoryService; }
    @PostMapping("/new")
    public ResponseEntity<Category> saveCategory(@RequestBody Category category){
        return ResponseEntity.ok()
                .body(categoryService.save(category));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Category>> retrieveCategories() {
        return ResponseEntity.ok().body(categoryService.getAll());
    }

    @PutMapping("/update")
    public ResponseEntity<Category> updateOrCreateCategory(@RequestBody Category category){
        return ResponseEntity.ok()
                .body(categoryService.save(category));
    }
}
