package com.example.proiectfinal.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Data
@Table(name="Info")
public class Info {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long descriptionId;

    @Column(nullable = false, length = 500)
    private String description;

    @OneToOne
    private Book book;

}
