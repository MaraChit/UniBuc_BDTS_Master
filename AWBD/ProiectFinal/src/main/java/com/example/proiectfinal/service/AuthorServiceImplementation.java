package com.example.proiectfinal.service;

import com.example.proiectfinal.model.Author;
import com.example.proiectfinal.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorServiceImplementation implements AuthorService {
    AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImplementation(AuthorRepository authorRepository) {

        this.authorRepository = authorRepository;
    }


    @Override
    public List<Author> findAll() {
        List<Author> categories = new ArrayList<>();
        authorRepository.findAll().iterator().forEachRemaining(categories::add);
        return categories ;
    }

    @Override
    public Author save(Author author) {
        Author savedAuthor = authorRepository.save(author);
        return savedAuthor;
    }
}
