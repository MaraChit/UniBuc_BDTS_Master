package com.awbd.AWBD_books.services;

import com.awbd.AWBD_books.domain.Category;
import com.awbd.AWBD_books.repositories.CatagoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{

    CatagoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CatagoryRepository categoryRepository) {

        this.categoryRepository = categoryRepository;
    }


    @Override
    public List<Category> findAll() {
        List<Category> categories = new ArrayList<>();
        categoryRepository.findAll().iterator().forEachRemaining(categories::add);
        return categories ;
    }
}
