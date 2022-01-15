package com.unibuc.books_reviews.repository;

import com.unibuc.books_reviews.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review,Integer> {

    @Query(value = "select * from review r  order by r.rating DESC limit 3" , nativeQuery = true)
    List<Review> findTopThreeReviews();


}
