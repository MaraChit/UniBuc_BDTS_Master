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
@Table(name="PublishingHouses")
public class PublishingHouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long publishingHouseId;

    @Column(nullable = false, length = 100)
    private String publishingHouseName;

    @Column(nullable = false, length = 100)
    private String country;

    @OneToMany(mappedBy = "publishingHouse")
    private List<Book> bookList;


}
