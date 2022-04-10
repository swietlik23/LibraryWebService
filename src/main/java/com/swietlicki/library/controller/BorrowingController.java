package com.swietlicki.library.controller;

import com.swietlicki.library.controller.dto.borrowingDto.BorrowingPostDto;
import com.swietlicki.library.controller.dto.borrowingDto.BorrowingWithIdsDto;
import com.swietlicki.library.controller.exception.bookException.BookNotFoundException;
import com.swietlicki.library.controller.exception.borrowingException.BorrowingNotFoundException;
import com.swietlicki.library.controller.exception.readerException.ReaderNotFoundException;
import com.swietlicki.library.model.Book;
import com.swietlicki.library.model.Borrowing;
import com.swietlicki.library.model.FinancialTransaction;
import com.swietlicki.library.model.Reader;
import com.swietlicki.library.service.BookService;
import com.swietlicki.library.service.BorrowingService;
import com.swietlicki.library.service.FinancialTransactionService;
import com.swietlicki.library.service.ReaderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

import static com.swietlicki.library.controller.mapper.BookDtoMapper.mapBookToBookDto;
import static com.swietlicki.library.controller.mapper.BorrowingDtoMapper.*;
import static com.swietlicki.library.model.Borrowing.BORROWING_TIME;
import static java.time.temporal.ChronoUnit.DAYS;

@RestController
@RequiredArgsConstructor
public class BorrowingController {

    private final BorrowingService borrowingService;
    private final BookService bookService;
    private final ReaderService readerService;
    private final FinancialTransactionService financialTransactionService;

    @GetMapping("/borrowings")
    public List<BorrowingWithIdsDto> getAllBorrowings(@RequestParam(required = false) Integer page) {
        int pageNumber = page != null && page >= 0 ? page : 0;
        return mapBorrowingsToBorrowingsDto(borrowingService.getBorrowings(pageNumber));
    }

    @PostMapping("/borrowings")
    public BorrowingWithIdsDto addBorrowing(@RequestBody BorrowingPostDto borrowingPostDto) {
        long readerId = borrowingPostDto.getReaderId();
        Reader reader = readerService.getSingleReader(readerId).orElseThrow(()-> new ReaderNotFoundException(readerId));

        long bookId = borrowingPostDto.getBookId();
        Book book = bookService.getSingleBook(bookId).orElseThrow(()-> new BookNotFoundException(bookId));
        if(mapBookToBookDto(book).getBorrowing() == null) {
            Borrowing borrowing = new Borrowing();
            borrowing.setBook(book);
            borrowing.setReader(reader);
            borrowing.setReturnUntilDate(LocalDateTime.now().plusDays(BORROWING_TIME));
            return mapBorrowingToBorrowingWithIdsDto(borrowingService.addBorrowing(borrowing));
        }
        return new BorrowingWithIdsDto();
    }

    @DeleteMapping("/borrowings/{id}")
    public void deleteBorrowing(@PathVariable long id) {
        BorrowingWithIdsDto borrowing = mapBorrowingToBorrowingWithIdsDto(borrowingService.getBorrowing(id)
                .orElseThrow(()-> new BorrowingNotFoundException(id)));
        LocalDateTime currentDate = LocalDateTime.now();
        long numberLateDays = DAYS.between(borrowing.getReturnUntilDate(), currentDate);
        if(numberLateDays > 0) {
            FinancialTransaction financialTransaction = new FinancialTransaction();
            financialTransaction.setCreated(currentDate);
            financialTransaction.setReaderId(borrowing.getReaderId());
            financialTransaction.setDescription("Penalty fee: " + borrowing.description());
            financialTransaction.setAmount(numberLateDays * FinancialTransaction.FEE_PER_DAY);
            financialTransactionService.addTransaction(financialTransaction);
            readerService.updateReaderBalance(borrowing.getReaderId());
        }
        borrowingService.deleteBorrowing(id);
    }

}
