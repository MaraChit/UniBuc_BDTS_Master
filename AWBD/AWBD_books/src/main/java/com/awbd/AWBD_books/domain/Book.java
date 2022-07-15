package com.awbd.AWBD_books.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;


import java.util.List;


@Entity
@Setter
@Getter
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;

    @Min(value=10, message ="min price 10")
    private Double price;

    private Boolean restored;

    @OneToOne(mappedBy = "book",
            cascade = CascadeType.ALL, orphanRemoval = true)
    private Info info;

    @OneToMany(mappedBy = "book")
    private List<Borrow> borrows;


    @ManyToMany(
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "book_category",
            joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "category_id",
                    referencedColumnName = "id"))
    private List<Category> categories;


    public void removeCategory(Category category) {
        category.getBooks().remove(this);
        categories.remove(category);
    }

}
