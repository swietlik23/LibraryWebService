package com.swietlicki.library.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.cache.annotation.EnableCaching;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String authors;
    private String language_code;
    private int num_pages;
    private String publication_date;
    private String publisher;


}
