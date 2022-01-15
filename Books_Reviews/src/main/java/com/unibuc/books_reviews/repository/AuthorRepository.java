package com.unibuc.books_reviews.repository;

import com.sun.source.doctree.AuthorTree;
import com.unibuc.books_reviews.dto.AuthorCountryDTO;
import com.unibuc.books_reviews.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

    @Query(value = "select * from author a where a.author_name = :name", nativeQuery = true)
    Author findAuthorByNameWithNativeQuery(String name);

    @Query(value = "select a.author_id AS authorId, a.author_name AS name from author a inner join address ad on a.address_id = ad.address_id  where ad.country = :country", nativeQuery = true)
    List<AuthorCountryDTO> findByCountry(String country);
}
