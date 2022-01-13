package com.unibuc.books_reviews.model;

import lombok.*;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookId;

    @NotNull(message = "Title cannot be null!!!")
    @NotEmpty(message = "Title cannot be empty!!!")
    private String title;

    @ManyToOne
    //@JsonIgnore
    @JoinColumn(name = "author_id")
    private Author author;

    @OneToOne
    @JoinColumn(name = "category_id")
    private Category category;

    private String plot;
    @Min(value = 1500, message = "The year can not be lower then 1500")
    private Integer year;

    @OneToMany(mappedBy = "book")
    @JsonIgnore
    private List<Review> reviews = new ArrayList<>();

    public Book(@NotNull(message = "Title cannot be null!!!") @NotEmpty(message = "Title cannot be empty!!!") String title) {
        this.title = title;
    }
}
