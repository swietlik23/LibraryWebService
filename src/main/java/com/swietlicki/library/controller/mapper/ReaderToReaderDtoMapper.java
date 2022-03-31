package com.swietlicki.library.controller.mapper;

import com.swietlicki.library.controller.dto.BorrowingDto;
import com.swietlicki.library.controller.dto.ReaderDto;
import com.swietlicki.library.model.Borrowing;
import com.swietlicki.library.model.Reader;

import java.util.List;
import java.util.stream.Collectors;

public class ReaderToReaderDtoMapper {

    public static ReaderDto mapReaderToReaderDto(Reader reader) {
        return ReaderDto.ReaderDtoBuilder.aReaderDto()
                .withId(reader.getId())
                .withFirstName(reader.getFirstName())
                .withLastName(reader.getLastName())
                .withEmail(reader.getEmail())
                .withBorrowings(mapBorrowingsToDtos(reader))
                .build();
    }

    private static List<BorrowingDto> mapBorrowingsToDtos(Reader reader) {
        return reader.getBorrowings().stream()
                .map(borrowing -> mapBorrowingToDto(borrowing)
                ).collect(Collectors.toList());
    }

    private static BorrowingDto mapBorrowingToDto(Borrowing borrowing) {
        return BorrowingDto.BorrowingDtoBuilder.aBorrowingDto()
                .withId(borrowing.getId())
                .withBorrowDate(borrowing.getBorrowDate())
                .withReturnDate(borrowing.getReturnDate())
                .build();
    }


}
