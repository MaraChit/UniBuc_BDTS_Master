package com.awbd.AWBD_books.domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
public class Reader {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "required field")
    private String lastName;

    private String firstName;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
    private java.util.Date birthDate;

    @OneToMany(mappedBy = "reader")
    private List<Borrow> borrows;


    private String  username;
    private String  password;
    private Integer enabled;


}
