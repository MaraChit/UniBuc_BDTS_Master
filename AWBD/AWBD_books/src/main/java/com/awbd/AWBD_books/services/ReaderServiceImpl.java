package com.awbd.AWBD_books.services;

import com.awbd.AWBD_books.domain.Reader;
import com.awbd.AWBD_books.exceptions.ResourceNotFoundException;
import com.awbd.AWBD_books.repositories.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReaderServiceImpl implements ReaderService {
    ReaderRepository readerRepository;

    @Autowired
    public ReaderServiceImpl(ReaderRepository readerRepository) {
        this.readerRepository = readerRepository;
    }

    @Override
    public Reader findById(Long l) {
        Optional<Reader> readerOptional = readerRepository.findById(l);
        if (!readerOptional.isPresent()) {
            //throw new RuntimeException("Participant not found!");
            throw new ResourceNotFoundException("reader " + l + " not found");
        }
        return readerOptional.get();
    }

    @Override
    public Reader save(Reader reader) {
        Reader savedReader = readerRepository.save(reader);
        return savedReader;
    }
}
