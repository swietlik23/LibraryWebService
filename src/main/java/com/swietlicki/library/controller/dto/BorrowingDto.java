package com.swietlicki.library.controller.dto;

import java.time.LocalDateTime;

public class BorrowingDto {

    private long id;
    private LocalDateTime borrowDate;
    private LocalDateTime returnDate;

    public long getId() {
        return id;
    }

    public LocalDateTime getBorrowDate() {
        return borrowDate;
    }

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    public static final class BorrowingDtoBuilder {
        private long id;
        private LocalDateTime borrowDate;
        private LocalDateTime returnDate;

        private BorrowingDtoBuilder() {
        }

        public static BorrowingDtoBuilder aBorrowingDto() {
            return new BorrowingDtoBuilder();
        }

        public BorrowingDtoBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public BorrowingDtoBuilder withBorrowDate(LocalDateTime borrowDate) {
            this.borrowDate = borrowDate;
            return this;
        }

        public BorrowingDtoBuilder withReturnDate(LocalDateTime returnDate) {
            this.returnDate = returnDate;
            return this;
        }

        public BorrowingDto build() {
            BorrowingDto borrowingDto = new BorrowingDto();
            borrowingDto.id = this.id;
            borrowingDto.borrowDate = this.borrowDate;
            borrowingDto.returnDate = this.returnDate;
            return borrowingDto;
        }
    }
}
