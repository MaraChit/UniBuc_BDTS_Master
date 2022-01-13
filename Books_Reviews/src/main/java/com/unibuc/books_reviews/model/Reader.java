package com.unibuc.books_reviews.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Reader {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int readerId;
    private String username;
    private String email;

    @OneToMany(mappedBy = "reader")
    @JsonIgnore
    private List<Review> reviews = new ArrayList<>();
}
