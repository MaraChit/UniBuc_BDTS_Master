package com.unibuc.books_reviews.repository;

import com.unibuc.books_reviews.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

    @Query(value = "select * from author a where a.author_name = :name", nativeQuery = true)
    Author findAuthorByNameWithNativeQuery(String name);
}
