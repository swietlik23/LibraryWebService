package com.swietlicki.library.controller.dto.borrowingDto;

public class BorrowingPostDto {

    private long bookId;
    private long readerId;

    public long getBookId() {
        return bookId;
    }

    public long getReaderId() {
        return readerId;
    }

    public static final class BorrowingPostDtoBuilder {
        private long bookId;
        private long readerId;

        private BorrowingPostDtoBuilder() {
        }

        public static BorrowingPostDtoBuilder aBorrowingPostDto() {
            return new BorrowingPostDtoBuilder();
        }

        public BorrowingPostDtoBuilder withBookId(long bookId) {
            this.bookId = bookId;
            return this;
        }

        public BorrowingPostDtoBuilder withReaderId(long readerId) {
            this.readerId = readerId;
            return this;
        }

        public BorrowingPostDto build() {
            BorrowingPostDto borrowingPostDto = new BorrowingPostDto();
            borrowingPostDto.readerId = this.readerId;
            borrowingPostDto.bookId = this.bookId;
            return borrowingPostDto;
        }
    }
}
