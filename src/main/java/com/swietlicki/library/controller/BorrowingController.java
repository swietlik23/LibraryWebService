package com.swietlicki.library.controller;

import com.swietlicki.library.controller.dto.BorrowingPostDto;
import com.swietlicki.library.controller.dto.BorrowingWithIdsDto;
import com.swietlicki.library.model.Book;
import com.swietlicki.library.model.Borrowing;
import com.swietlicki.library.model.Reader;
import com.swietlicki.library.service.BookService;
import com.swietlicki.library.service.BorrowingService;
import com.swietlicki.library.service.ReaderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.swietlicki.library.controller.mapper.BorrowingDtoMapper.mapBorrowingToBorrowingWithIdsDto;
import static com.swietlicki.library.controller.mapper.BorrowingDtoMapper.mapBorrowingsToBorrowingsDto;

@RestController
@RequiredArgsConstructor
public class BorrowingController {

    private final BorrowingService borrowingService;
    private final BookService bookService;
    private final ReaderService readerService;

    @GetMapping("/borrowings")
    public List<BorrowingWithIdsDto> getAllBorrowings(@RequestParam(required = false) Integer page) {
        int pageNumber = page != null && page >= 0 ? page : 0;
        return mapBorrowingsToBorrowingsDto(borrowingService.getBorrowings(pageNumber));
    }

    @PostMapping("/borrowings")
    public BorrowingWithIdsDto addBorrowing(@RequestBody BorrowingPostDto borrowingPostDto) {
        Book book = bookService.getSingleBook(borrowingPostDto.getBookId());
        Reader reader = readerService.getSingleReader(borrowingPostDto.getReaderId());
        Borrowing borrowing = new Borrowing();
        borrowing.setBook(book);
        borrowing.setReader(reader);
        return mapBorrowingToBorrowingWithIdsDto(borrowingService.addBorrowing(borrowing));
    }

    @DeleteMapping("/borrowings/{id}")
    public void deleteBorrowing(@PathVariable long id) {
        borrowingService.deleteBorrowing(id);
    }

}
