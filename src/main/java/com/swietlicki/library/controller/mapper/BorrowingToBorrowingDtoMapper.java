package com.swietlicki.library.controller.mapper;

import com.swietlicki.library.controller.dto.BorrowingWithReaderIdDto;
import com.swietlicki.library.model.Borrowing;

import java.util.List;
import java.util.stream.Collectors;

public class BorrowingToBorrowingDtoMapper {

    public static List<BorrowingWithReaderIdDto> mapBorrowingsToBorrowingsDto (List<Borrowing> borrowings) {
        return borrowings.stream()
                .map(borrowing -> BorrowingWithReaderIdDto.BorrowingWithReaderDtoBuilder.aBorrowingWithReaderDto()
                        .withId(borrowing.getId())
                        .withBorrowDate(borrowing.getBorrowDate())
                        .withBorrowDate(borrowing.getReturnDate())
                        .withReaderId(borrowing.getReader().getId())
                        .build()
                ).collect(Collectors.toList());
    }
}
