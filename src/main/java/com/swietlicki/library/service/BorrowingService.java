package com.swietlicki.library.service;

import com.swietlicki.library.model.Book;
import com.swietlicki.library.model.Borrowing;
import com.swietlicki.library.model.Reader;
import com.swietlicki.library.repository.BookRepository;
import com.swietlicki.library.repository.BorrowingRepisitory;
import com.swietlicki.library.repository.ReaderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BorrowingService {

    private static final int PAGE_SIZE = 15;
    private final BorrowingRepisitory borrowingRepisitory;
    private final BookService bookService;
    private final ReaderService readerService;

    public List<Borrowing> getAllBorrowings(int page) {
        return borrowingRepisitory.findAllBorrowings(PageRequest.of(page, PAGE_SIZE));
    }

    public Borrowing lendToReader(long book_id, long reader_id) {
        Book book = bookService.getSingleBook(book_id);
        Reader reader = readerService.getSingleReader(reader_id);
        LocalDateTime borrowTime = LocalDateTime.now();

        Borrowing borrowing = new Borrowing();
        borrowing.setBook(book);
        borrowing.setReader(reader);
        borrowing.setBorrow_date(borrowTime);
        return borrowingRepisitory.save(borrowing);
    }
}
