package com.unibuc.books_reviews.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int addressId;

    @NotEmpty(message = "Street name cannot be empty!!!")
    private String street;

    @Min(value = 1, message = "Street number can not be lower then 1")
    @Max(value = 1000, message = "Street number can not be bigger then 1000")
    private Integer streetNo;

    @NotEmpty(message = "City name cannot be empty!!!")
    private String city;

    @NotEmpty(message = "Country name cannot be empty!!!")
    private String country;

}
