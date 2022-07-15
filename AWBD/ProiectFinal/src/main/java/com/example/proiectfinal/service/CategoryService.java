package com.example.proiectfinal.service;

import com.example.proiectfinal.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
    Category save(Category category);
}