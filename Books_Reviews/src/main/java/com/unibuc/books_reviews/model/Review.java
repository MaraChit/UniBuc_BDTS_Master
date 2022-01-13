package com.unibuc.books_reviews.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reviewId;

    private String reviewText;

    @ManyToOne
    //@JsonIgnore
    @JoinColumn(name = "reader_id")
    private Reader reader;

    @ManyToOne
    //@JsonIgnore
    @JoinColumn(name = "book_id")
    private Book book;

    //goes from 1 to 10
    private Integer rating;
}
