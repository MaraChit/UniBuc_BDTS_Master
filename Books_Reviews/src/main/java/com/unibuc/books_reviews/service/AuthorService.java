package com.unibuc.books_reviews.service;

import com.unibuc.books_reviews.dto.AuthorCountryDTO;
import com.unibuc.books_reviews.model.Author;
import com.unibuc.books_reviews.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) { this.authorRepository = authorRepository; }

    public Author save (Author author) {return authorRepository.save(author);}
    public List<Author> getAll() {
        return authorRepository.findAll();
    }
    public Author retrieveByName(String name) {
        return authorRepository.findAuthorByNameWithNativeQuery(name);
    }
    public List<AuthorCountryDTO> getByCountry(String country){ return authorRepository.findByCountry(country);}
}
