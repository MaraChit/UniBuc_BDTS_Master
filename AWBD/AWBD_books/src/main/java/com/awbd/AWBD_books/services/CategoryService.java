package com.awbd.AWBD_books.services;

import com.awbd.AWBD_books.domain.Category;
import java.util.List;

public interface CategoryService {
    List<Category> findAll();
}
