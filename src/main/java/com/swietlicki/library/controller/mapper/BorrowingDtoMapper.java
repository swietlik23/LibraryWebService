package com.swietlicki.library.controller.mapper;

import com.swietlicki.library.controller.dto.borrowingDto.BorrowingDetailsDto;
import com.swietlicki.library.controller.dto.borrowingDto.BorrowingWithIdsDto;
import com.swietlicki.library.model.Borrowing;

import java.util.List;
import java.util.stream.Collectors;

public class BorrowingDtoMapper {

    public static List<BorrowingWithIdsDto> mapBorrowingsToBorrowingsDto(List<Borrowing> borrowings) {
        return borrowings.stream()
                .map(borrowing -> BorrowingWithIdsDto.BorrowingWithReaderDtoBuilder.aBorrowingWithReaderDto()
                        .withId(borrowing.getId())
                        .withBorrowDate(borrowing.getBorrowDate())
                        .withReturnUntilDate(borrowing.getReturnUntilDate())
                        .withBookId(borrowing.getBook().getId())
                        .withReaderId(borrowing.getReader().getId())
                        .build()
                ).collect(Collectors.toList());
    }

    public static BorrowingDetailsDto mapBorrowingToBorrowingDatesDto(Borrowing borrowing) {
        if(borrowing == null) {
            return null;
        } else {
            return BorrowingDetailsDto.BorrowingDtoBuilder.aBorrowingDto()
                    .withId(borrowing.getId())
                    .withBorrowDate(borrowing.getBorrowDate())
                    .withReturnUntilDate(borrowing.getReturnUntilDate())
                    .build();
        }
    }

    public static BorrowingWithIdsDto mapBorrowingToBorrowingWithIdsDto(Borrowing borrowing) {
        return BorrowingWithIdsDto.BorrowingWithReaderDtoBuilder.aBorrowingWithReaderDto()
                .withId(borrowing.getId())
                .withBorrowDate(borrowing.getBorrowDate())
                .withReturnUntilDate(borrowing.getReturnUntilDate())
                .withBookId(borrowing.getBook().getId())
                .withReaderId(borrowing.getReader().getId())
                .build();
    }
}
