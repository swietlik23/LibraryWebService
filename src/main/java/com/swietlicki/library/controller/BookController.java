package com.swietlicki.library.controller;

import com.swietlicki.library.model.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        throw new IllegalArgumentException("Not implemented yet");
    }

    @GetMapping("/books/{id}")
    public Book getSingleBook(@PathVariable long id) {
        throw new IllegalArgumentException("Not implemented yet");
    }

}
