package com.swietlicki.library.controller;

import com.swietlicki.library.model.Borrowing;
import com.swietlicki.library.service.BorrowingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BorrowingController {

    private final BorrowingService borrowingService;

    @GetMapping("/borrowings")
    public List<Borrowing> getAllBorrowings(@RequestParam(required = false) Integer page) {
        int pageNumber = page != null && page >= 0 ? page : 0;
        return borrowingService.getAllBorrowings(pageNumber);
    }

    @PostMapping ("/borrowings/{book_id}/{reader_id}")
    public Borrowing borrowing(@PathVariable long book_id,
                               @PathVariable long reader_id) {
        return borrowingService.lendToReader(book_id, reader_id);
    }

}
