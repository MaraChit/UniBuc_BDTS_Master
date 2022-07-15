package com.awbd.AWBD_books.repositories;

import com.awbd.AWBD_books.domain.Reader;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReaderRepository extends CrudRepository<Reader, Long> {
    List<Reader> findByLastNameLike(String lastName);
    List<Reader> findByIdIn(List<Long> ids);

}
