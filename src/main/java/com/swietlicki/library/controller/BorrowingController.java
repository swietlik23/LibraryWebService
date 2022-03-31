package com.swietlicki.library.controller;

import com.swietlicki.library.controller.dto.BorrowingWithReaderIdDto;
import com.swietlicki.library.service.BorrowingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.swietlicki.library.controller.mapper.BorrowingToBorrowingDtoMapper.mapBorrowingsToBorrowingsDto;

@RestController
@RequiredArgsConstructor
public class BorrowingController {

    private final BorrowingService borrowingService;

    @GetMapping("/borrowings")
    public List<BorrowingWithReaderIdDto> getAllBorrowings(@RequestParam(required = false) Integer page) {
        int pageNumber = page != null && page >= 0 ? page : 0;
        return mapBorrowingsToBorrowingsDto(borrowingService.getBorrowings(pageNumber));
    }

}
