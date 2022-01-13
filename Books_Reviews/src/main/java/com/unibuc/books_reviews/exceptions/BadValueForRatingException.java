package com.unibuc.books_reviews.exceptions;

public class BadValueForRatingException extends RuntimeException{

    public BadValueForRatingException(String message) {
        super(message);
    }
}
