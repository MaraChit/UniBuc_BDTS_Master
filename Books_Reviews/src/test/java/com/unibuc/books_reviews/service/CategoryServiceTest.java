package com.unibuc.books_reviews.service;

import com.unibuc.books_reviews.model.Category;
import com.unibuc.books_reviews.repository.CategoryRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CategoryServiceTest {
    @InjectMocks
    CategoryService categoryService;

    @Mock
    CategoryRepository categoryRepository;

    @Test
    @DisplayName("Running save Category in a happy flow")
    void saveNewCategoryHappyFlow(){
        Category category1 = new Category(1,"Category1", "description1");
        when(categoryRepository.save(category1)).thenReturn(category1);
        Category result = categoryService.save(category1);
        assertEquals(category1.getCategoryName(), result.getCategoryName());
    }

    @Test
    @DisplayName("Running getAll categories in happy flow")
    void getAllHappyFlow(){
        Category category1 = new Category(1,"Category1", "description1");
        Category category2 = new Category(2,"Category2", "description2");
        List<Category> categoryList = new ArrayList<>();
        categoryList.add(category1);
        categoryList.add(category2);
        when(categoryRepository.findAll()).thenReturn(categoryList);
        List<Category> result = categoryService.getAll();
        assertEquals(2, result.size());
    }

    @Test
    @DisplayName("Running getById categories in happy flow")
    void getByIdHappyFlow(){
        Category category1 = new Category(1,"Category1", "description1");
        when(categoryRepository.getById(1)).thenReturn(category1);
        Category result = categoryService.getById(1);
        assertEquals(category1, result);
    }


}
