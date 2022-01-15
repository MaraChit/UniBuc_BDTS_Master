package com.unibuc.books_reviews.service;

import com.unibuc.books_reviews.exceptions.BadValueForRatingException;
import com.unibuc.books_reviews.model.Review;
import com.unibuc.books_reviews.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public Review save (Review review) {
        if(review.getRating()>10 || review.getRating()<0)
            throw new BadValueForRatingException("The rating has to be between 1 and 10.");
        return reviewRepository.save(review);}

    public List<Review> getAll() {
        return reviewRepository.findAll();
    }

    public Review getById(int id){ return reviewRepository.getById(id);}

    public boolean delete(int id){
        if (this.getById(id)!=null)
        {
            reviewRepository.deleteById(id);
            return true;
        }

        return false;
    }

    public List<Review> getTopThree(){
        return reviewRepository.findTopThreeReviews();
    }
}
