package com.swietlicki.library.controller.mapper;

import com.swietlicki.library.controller.dto.borrowingDto.BorrowingDetailsDto;
import com.swietlicki.library.controller.dto.readerDto.ReaderDto;
import com.swietlicki.library.controller.dto.readerDto.ReaderPostDto;
import com.swietlicki.library.model.Borrowing;
import com.swietlicki.library.model.Reader;

import java.util.List;
import java.util.stream.Collectors;

public class ReaderDtoMapper {

    public static ReaderDto mapReaderToReaderDto(Reader reader) {
        return ReaderDto.ReaderDtoBuilder.aReaderDto()
                .withId(reader.getId())
                .withFirstName(reader.getFirstName())
                .withLastName(reader.getLastName())
                .withEmail(reader.getEmail())
                .withBalance(reader.getBalance())
                .withBorrowings(mapBorrowingsToDtos(reader))
                .build();
    }

    public static ReaderPostDto mapReaderToReaderPostDto(Reader reader) {
        return ReaderPostDto.ReaderPostDtoBuilder.aReaderPostDto()
                .withFirstName(reader.getFirstName())
                .withLastName(reader.getLastName())
                .withEmail(reader.getEmail())
                .build();
    }

    public static Reader mapReaderPostDtoToReader(Long id, ReaderPostDto readerPostDto) {
        Reader reader = new Reader();
        if(id != null) {
            reader.setId(id);
        }
        reader.setFirstName(readerPostDto.getFirstName());
        reader.setLastName(readerPostDto.getLastName());
        reader.setEmail(readerPostDto.getEmail());
        return reader;
    }

    private static List<BorrowingDetailsDto> mapBorrowingsToDtos(Reader reader) {
        return reader.getBorrowings().stream()
                .map(borrowing -> mapBorrowingToDto(borrowing)
                ).collect(Collectors.toList());
    }

    private static BorrowingDetailsDto mapBorrowingToDto(Borrowing borrowing) {
        return BorrowingDetailsDto.BorrowingDtoBuilder.aBorrowingDto()
                .withId(borrowing.getId())
                .withBorrowDate(borrowing.getBorrowDate())
                .withReturnUntilDate(borrowing.getReturnUntilDate())
                .build();
    }


}
