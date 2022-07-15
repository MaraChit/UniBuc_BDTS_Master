package com.awbd.AWBD_books.domain;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;


    @ManyToMany(mappedBy = "categories",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Book> books;


}
