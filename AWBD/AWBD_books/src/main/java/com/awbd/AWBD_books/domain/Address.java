package com.awbd.AWBD_books.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String Country;
    private String City;
    private String Street;
    private String PostalCode;

    @OneToOne
    private Book book;
}
