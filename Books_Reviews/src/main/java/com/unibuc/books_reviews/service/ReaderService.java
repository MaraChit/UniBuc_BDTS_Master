package com.unibuc.books_reviews.service;

import com.unibuc.books_reviews.model.Reader;
import com.unibuc.books_reviews.repository.ReaderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReaderService {

    private final ReaderRepository readerRepository;

    public ReaderService(ReaderRepository readerRepository) { this.readerRepository = readerRepository; }

    public Reader save (Reader reader){ return readerRepository.save(reader); }
    public List<Reader> getAll() {
        return readerRepository.findAll();
    }
}

