package com.awbd.AWBD_books.repositories;

import com.awbd.AWBD_books.domain.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatagoryRepository extends CrudRepository<Category, Long> {
}
