package com.swietlicki.library.controller;

import com.swietlicki.library.controller.dto.bookDto.BookDetailsDto;
import com.swietlicki.library.controller.dto.bookDto.BookDto;
import com.swietlicki.library.controller.dto.bookDto.BookPostDto;
import com.swietlicki.library.controller.exception.bookException.BookNotFoundException;
import com.swietlicki.library.service.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.swietlicki.library.controller.mapper.BookDtoMapper.*;

@RestController
@RequiredArgsConstructor
public class BookController {

    private static final Long EMPTY_ID = null;
    private final BookService bookService;

    @ApiOperation(value = "Find all books")
    @GetMapping("/books")
    public List<BookDetailsDto> getAllBooks(@RequestParam(required = false) Integer page) {
        int pageNumber = page != null && page >= 0 ? page : 0;
        return mapBooksToBooksDetailsDtos(bookService.getBooks(pageNumber));
    }

    @ApiOperation(value = "Find book by id")
    @GetMapping("/books/{id}")
    public BookDto getSingleBook(@ApiParam(value = "Type unique id of book", example = "10") @PathVariable long id) {
        return mapBookToBookDto(bookService.getSingleBook(id));
    }

    @ApiOperation(value = "Find book by title")
    @GetMapping("/books/title={title}")
    public List<BookDetailsDto> getAllByTitle(@ApiParam(value = "Type the word you want to search with",
                                                example = "harry")
                                                  @PathVariable String title,
                                    @RequestParam(required = false) Integer page) {
        int pageNumber = page != null && page >= 0 ? page : 0;
        return mapBooksToBooksDetailsDtos(bookService.getAllByTitle(title, pageNumber));
    }

    @ApiOperation(value = "Add new book")
    @PostMapping("/books")
    public BookPostDto addBook(@RequestBody BookPostDto bookPostDto) {
        return mapBookToBookPostDto(bookService.addBook(mapBookPostDtoToBook(EMPTY_ID, bookPostDto)));
    }

    @ApiOperation(value = "Update book fields or post book if book with the id does not exist")
    @PutMapping("/books/{id}/edit")
    public BookPostDto editBook(@ApiParam(value = "unique id of book", example = "10")
                                    @PathVariable Long id, @RequestBody BookPostDto bookPostDto) {
        return mapBookToBookPostDto(bookService.editBook(mapBookPostDtoToBook(id, bookPostDto)));
    }

    @ApiOperation(value = "Delete book")
    @DeleteMapping("/books/{id}")
    public void deleteBook(@ApiParam(value = "Type unique id of book", example = "1")
                             @PathVariable long id) {
        bookService.deleteBook(id);
    }

}
