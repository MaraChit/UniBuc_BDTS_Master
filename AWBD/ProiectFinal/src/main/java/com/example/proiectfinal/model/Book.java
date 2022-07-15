package com.example.proiectfinal.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@Entity
@Getter
@Setter
@Data
@Table(name="Books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false,  length = 100)
    private String publishingDate;

    @Column(nullable = false,  length = 100)
    @Max(value=5, message ="Maximum value is 5")
    @Min(value=1, message ="Min value is 1")
    private float rating;

    @OneToOne(mappedBy = "book",
            cascade = CascadeType.ALL, orphanRemoval = true)
    private Info info;

    @ManyToOne
    private PublishingHouse publishingHouse;

    @OneToMany(mappedBy = "book")
    private List<Awards> awards;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "book_author", joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    private List<Author> authorList;

    @ManyToMany
    @JoinTable(name = "book_category",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<Category> categories;

}
