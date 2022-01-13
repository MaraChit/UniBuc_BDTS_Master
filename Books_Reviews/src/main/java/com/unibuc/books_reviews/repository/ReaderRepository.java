package com.unibuc.books_reviews.repository;

import com.unibuc.books_reviews.model.Reader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReaderRepository extends JpaRepository<Reader,Integer> {
}
