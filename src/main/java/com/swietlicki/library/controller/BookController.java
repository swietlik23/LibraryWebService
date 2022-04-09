package com.swietlicki.library.controller;

import com.swietlicki.library.controller.dto.bookDto.BookDetailsDto;
import com.swietlicki.library.controller.dto.bookDto.BookDto;
import com.swietlicki.library.controller.dto.bookDto.BookPostDto;
import com.swietlicki.library.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.swietlicki.library.controller.mapper.BookDtoMapper.*;

@RestController
@RequiredArgsConstructor
public class BookController {

    private static final Long EMPTY_ID = null;
    private final BookService bookService;

    @GetMapping("/books")
    public List<BookDetailsDto> getAllBooks(@RequestParam(required = false) Integer page) {
        int pageNumber = page != null && page >= 0 ? page : 0;
        return mapBooksToBooksDetailsDtos(bookService.getBooks(pageNumber));
    }

    @GetMapping("/books/{id}")
    public BookDto getSingleBook(@PathVariable long id) {
        return mapBookToBookDto(bookService.getSingleBook(id));
    }
    @GetMapping("/books/title={title}")
    public List<BookDetailsDto> getAllByTitle(@PathVariable String title,
                                    @RequestParam(required = false) Integer page) {
        int pageNumber = page != null && page >= 0 ? page : 0;
        return mapBooksToBooksDetailsDtos(bookService.getAllByTitle(title, pageNumber));
    }

    @PostMapping("/books")
    public BookPostDto addBook(@RequestBody BookPostDto bookPostDto) {
        return mapBookToBookPostDto(bookService.addBook(mapBookPostDtoToBook(EMPTY_ID, bookPostDto)));
    }

    @PutMapping("/books/{id}/edit")
    public BookPostDto editBook(@PathVariable Long id, @RequestBody BookPostDto bookPostDto) {
        return mapBookToBookPostDto(bookService.editBook(mapBookPostDtoToBook(id, bookPostDto)));
    }

}
