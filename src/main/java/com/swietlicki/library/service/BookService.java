package com.swietlicki.library.service;

import com.swietlicki.library.controller.exception.bookException.BookNotFoundException;
import com.swietlicki.library.controller.exception.readerException.ReaderNotFoundException;
import com.swietlicki.library.model.Book;
import com.swietlicki.library.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {

    private static final int PAGE_SIZE = 15;
    private final BookRepository bookRepository;

    public List<Book> getBooks(int page) {
        return bookRepository.findAllBooks(PageRequest.of(page,PAGE_SIZE));
    }

    public Book getSingleBook(long id) {
        return bookRepository.findById(id).orElseThrow(()-> new BookNotFoundException(id));
    }

    public List<Book> getAllByTitle(String title, int page) {
        return bookRepository.findAllByTitle(title.toLowerCase(), PageRequest.of(page,PAGE_SIZE));
    }

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public Book editBook(Book book) {
        return bookRepository.save(book);
    }

    public void deleteBook(long id) {
        if(!bookRepository.existsById(id)) {
            throw new BookNotFoundException(id);
        }
        bookRepository.deleteById(id);
    }
}
