package com.example.proiectfinal.service;

import com.example.proiectfinal.model.Author;

import java.util.List;

public interface AuthorService {

    List<Author> findAll();
    Author save(Author author);
}
