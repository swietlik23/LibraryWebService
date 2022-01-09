package com.swietlicki.library.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
public class Borrowing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDateTime borrow_date;
    private LocalDateTime return_date = null;

    @OneToOne
    private Book book;

    @ManyToOne
    private Reader reader;
}
