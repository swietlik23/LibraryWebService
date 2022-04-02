package com.swietlicki.library.controller.mapper;

import com.swietlicki.library.controller.dto.BorrowingDatesDto;
import com.swietlicki.library.controller.dto.BorrowingPostDto;
import com.swietlicki.library.controller.dto.BorrowingWithIdsDto;
import com.swietlicki.library.model.Borrowing;

import java.util.List;
import java.util.stream.Collectors;

public class BorrowingDtoMapper {

    public static List<BorrowingWithIdsDto> mapBorrowingsToBorrowingsDto(List<Borrowing> borrowings) {
        return borrowings.stream()
                .map(borrowing -> BorrowingWithIdsDto.BorrowingWithReaderDtoBuilder.aBorrowingWithReaderDto()
                        .withId(borrowing.getId())
                        .withBorrowDate(borrowing.getBorrowDate())
                        .withReturnDate(borrowing.getReturnDate())
                        .withBookId(borrowing.getBook().getId())
                        .withReaderId(borrowing.getReader().getId())
                        .build()
                ).collect(Collectors.toList());
    }

    public static BorrowingDatesDto mapBorrowingToBorrowingDatesDto(Borrowing borrowing) {
        if(borrowing == null) {
            return null;
        } else {
            return BorrowingDatesDto.BorrowingDtoBuilder.aBorrowingDto()
                    .withId(borrowing.getId())
                    .withBorrowDate(borrowing.getBorrowDate())
                    .withReturnDate(borrowing.getReturnDate())
                    .build();
        }
    }

    public static BorrowingWithIdsDto mapBorrowingToBorrowingWithIdsDto(Borrowing borrowing) {
        return BorrowingWithIdsDto.BorrowingWithReaderDtoBuilder.aBorrowingWithReaderDto()
                .withId(borrowing.getId())
                .withBorrowDate(borrowing.getBorrowDate())
                .withReturnDate(borrowing.getReturnDate())
                .withBookId(borrowing.getBook().getId())
                .withReaderId(borrowing.getReader().getId())
                .build();
    }
}
