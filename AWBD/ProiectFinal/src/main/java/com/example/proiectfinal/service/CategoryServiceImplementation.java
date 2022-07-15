package com.example.proiectfinal.service;

import com.example.proiectfinal.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.proiectfinal.repository.CategoryRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImplementation implements CategoryService{

    CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImplementation(CategoryRepository categoryRepository) {

        this.categoryRepository = categoryRepository;
    }


    @Override
    public List<Category> findAll() {
        List<Category> categories = new ArrayList<>();
        categoryRepository.findAll().iterator().forEachRemaining(categories::add);
        return categories ;
    }
    
    @Override
    public Category save(Category category) {
        Category savedCategory = categoryRepository.save(category);
        return savedCategory;
    }
}
