package com.awbd.AWBD_books.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Borrow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double price;
    private Long timestamp;

    @ManyToOne
    private Reader reader;

    @ManyToOne
    private Book book;


}
