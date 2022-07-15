package com.awbd.AWBD_books.services;

import com.awbd.AWBD_books.domain.Reader;

public interface ReaderService {
    Reader findById(Long l);
    Reader save(Reader reader);
}
