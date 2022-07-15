package com.awbd.AWBD_books.repositories;

import com.awbd.AWBD_books.domain.Info;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfoRepository extends CrudRepository<Info, Long> {
}
