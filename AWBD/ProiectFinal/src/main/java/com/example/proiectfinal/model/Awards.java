package com.example.proiectfinal.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Data
@Table(name="Awards")
public class Awards {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long awardId;

    @Column(nullable = false, length = 500)
    private String awardName;

    @ManyToOne
    private Book book;
}
