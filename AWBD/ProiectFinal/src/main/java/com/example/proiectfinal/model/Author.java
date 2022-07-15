package com.example.proiectfinal.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Data
@Table(name="Authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long authorId;

    @Column(nullable = false,  length = 100)
    private String FirstName;

    @Column(nullable = false,  length = 100)
    private String LastName;

    @ManyToMany(mappedBy = "authorList")
    private List<Book> bookList;

}
