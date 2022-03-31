package com.swietlicki.library.controller.dto;

import java.time.LocalDateTime;

public class BorrowingWithReaderIdDto {

    private long id;
    private LocalDateTime borrowDate;
    private LocalDateTime returnDate;
    private long readerId;

    public long getId() {
        return id;
    }

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    public LocalDateTime getBorrowDate() {
        return borrowDate;
    }

    public long getReaderId() {
        return readerId;
    }

    public static final class BorrowingWithReaderDtoBuilder {
        private long id;
        private LocalDateTime borrowDate;
        private LocalDateTime returnDate;
        private long readerId;

        private BorrowingWithReaderDtoBuilder() {
        }

        public static BorrowingWithReaderDtoBuilder aBorrowingWithReaderDto() {
            return new BorrowingWithReaderDtoBuilder();
        }

        public BorrowingWithReaderDtoBuilder withId(long id) {
            this.id = id;
            return this;
        }

        public BorrowingWithReaderDtoBuilder withBorrowDate(LocalDateTime borrowDate) {
            this.borrowDate = borrowDate;
            return this;
        }

        public BorrowingWithReaderDtoBuilder withReturnDate(LocalDateTime returnDate) {
            this.returnDate = returnDate;
            return this;
        }

        public BorrowingWithReaderDtoBuilder withReaderId(long readerId) {
            this.readerId = readerId;
            return this;
        }

        public BorrowingWithReaderIdDto build() {
            BorrowingWithReaderIdDto borrowingWithReaderIdDto = new BorrowingWithReaderIdDto();
            borrowingWithReaderIdDto.returnDate = this.returnDate;
            borrowingWithReaderIdDto.readerId = this.readerId;
            borrowingWithReaderIdDto.id = this.id;
            borrowingWithReaderIdDto.borrowDate = this.borrowDate;
            return borrowingWithReaderIdDto;
        }
    }
}
