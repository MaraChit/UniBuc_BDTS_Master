package com.unibuc.books_reviews.controller;

import com.unibuc.books_reviews.model.Review;
import com.unibuc.books_reviews.service.ReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review")
public class ReviewController {
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping("/new")
    public ResponseEntity<Review> saveReview(@RequestBody Review review){
        return ResponseEntity.ok()
                .body(reviewService.save(review));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Review>> retrieveReviews() {
        return ResponseEntity.ok().body(reviewService.getAll());
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Boolean> deleteReview(@RequestParam int id){return ResponseEntity.ok().body(reviewService.delete(id));}

    @GetMapping("/top3")
    public ResponseEntity<List<Review>> getTopThree()
    {
        return ResponseEntity.ok().body(reviewService.getTopThree());
    }
}
