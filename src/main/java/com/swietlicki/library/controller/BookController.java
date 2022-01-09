package com.swietlicki.library.controller;

import com.swietlicki.library.model.Book;
import com.swietlicki.library.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping("/books")
    public List<Book> getAllBooks(@RequestParam(required = false) Integer page) {
        int pageNumber = page != null && page >= 0 ? page : 0;
        return bookService.getBooks(pageNumber);
    }

    @GetMapping("/books/{id}")
    public Book getSingleBook(@PathVariable long id) {
        return bookService.getSingleBook(id);
    }
    @GetMapping("/books/title={title}")
    public List<Book> getAllByTitle(@PathVariable String title,
                                    @RequestParam(required = false) Integer page) {
        int pageNumber = page != null && page >= 0 ? page : 0;
        return bookService.getAllByTitle(title, pageNumber);
    }

    @PostMapping("/books")
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @PutMapping("/books")
    public Book editBook(@RequestBody Book book) {
        return bookService.editBook(book);
    }

}
