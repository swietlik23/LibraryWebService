package com.swietlicki.library.controller.mapper;

import com.swietlicki.library.controller.dto.bookDto.BookDetailsDto;
import com.swietlicki.library.controller.dto.bookDto.BookDto;
import com.swietlicki.library.controller.dto.bookDto.BookPostDto;
import com.swietlicki.library.model.Book;

import java.util.List;
import java.util.stream.Collectors;

import static com.swietlicki.library.controller.mapper.BorrowingDtoMapper.mapBorrowingToBorrowingDatesDto;

public class BookDtoMapper {

    public static List<BookDetailsDto> mapBooksToBooksDetailsDtos(List<Book> books) {
        return books.stream()
                .map(book -> BookDetailsDto.BookDetailsDtoBuilder.aBookDetailsDto()
                        .withId(book.getId())
                        .withTitle(book.getTitle())
                        .withAuthors(book.getAuthors())
                        .withLanguage_code(book.getLanguage_code())
                        .withNum_pages(book.getNum_pages())
                        .withPublication_date(book.getPublication_date())
                        .withPublisher(book.getPublisher())
                        .build()
                ).collect(Collectors.toList());
    }

    public static BookDto mapBookToBookDto(Book book) {
        return BookDto.BookDtoBuilder.aBookDto()
                .withId(book.getId())
                .withTitle(book.getTitle())
                .withAuthors(book.getAuthors())
                .withLanguage_code(book.getLanguage_code())
                .withNum_pages(book.getNum_pages())
                .withPublication_date(book.getPublication_date())
                .withPublisher(book.getPublisher())
                .withBorrowingDto(mapBorrowingToBorrowingDatesDto(book.getBorrowing()))
                .build();
    }

    public static BookPostDto mapBookToBookPostDto(Book book) {
        return BookPostDto.BookPostDtoBuilder.aBookPostDto()
                .withTitle(book.getTitle())
                .withAuthors(book.getAuthors())
                .withLanguage_code(book.getLanguage_code())
                .withNum_pages(book.getNum_pages())
                .withPublication_date(book.getPublication_date())
                .withPublisher(book.getPublisher())
                .build();
    }

    public static Book mapBookPostDtoToBook(Long id, BookPostDto bookPostDto) {
        Book book = new Book();
        book.setAuthors(bookPostDto.getAuthors());
        book.setLanguage_code(bookPostDto.getLanguage_code());
        book.setNum_pages(bookPostDto.getNum_pages());
        book.setPublisher(bookPostDto.getPublisher());
        book.setTitle(bookPostDto.getTitle());
        book.setPublication_date(bookPostDto.getPublication_date());
        if(id != null) {
            book.setId(id);
        }
        return book;

    }
}
