package com.unibuc.books_reviews.repository;

import com.unibuc.books_reviews.dto.BookTopDTO;
import com.unibuc.books_reviews.model.Book;
import org.javatuples.Pair;
import org.javatuples.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    @Query(value = "select b.book_id AS bookId, b.title AS title from book b inner join review r on b.book_id = r.book_id group by b.book_id order by AVG(r.rating) DESC limit 3" , nativeQuery = true)
    List<BookTopDTO> findTopThreeBooks();
}
