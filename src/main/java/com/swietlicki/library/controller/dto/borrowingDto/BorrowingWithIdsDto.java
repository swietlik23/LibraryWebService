package com.swietlicki.library.controller.dto.borrowingDto;

import java.time.LocalDateTime;

public class BorrowingWithIdsDto {

    private long id;
    private LocalDateTime borrowDate;
    private LocalDateTime returnUntilDate;
    private long bookId;
    private long readerId;

    public long getId() {
        return id;
    }

    public LocalDateTime getReturnUntilDate() {
        return returnUntilDate;
    }

    public LocalDateTime getBorrowDate() {
        return borrowDate;
    }

    public long getBookId() {
        return bookId;
    }

    public long getReaderId() {
        return readerId;
    }

    public String description() {
        return  "id=" + id +
                ", borrowDate=" + borrowDate +
                ", returnUntilDate=" + returnUntilDate +
                ", bookId=" + bookId +
                ", readerId=" + readerId +
                '}';
    }

    public static final class BorrowingWithReaderDtoBuilder {
        private long id;
        private LocalDateTime borrowDate;
        private LocalDateTime returnUntilDate;
        private long bookId;
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

        public BorrowingWithReaderDtoBuilder withReturnUntilDate(LocalDateTime returnUntilDate) {
            this.returnUntilDate = returnUntilDate;
            return this;
        }

        public BorrowingWithReaderDtoBuilder withBookId(long bookId) {
            this.bookId = bookId;
            return this;
        }

        public BorrowingWithReaderDtoBuilder withReaderId(long readerId) {
            this.readerId = readerId;
            return this;
        }

        public BorrowingWithIdsDto build() {
            BorrowingWithIdsDto borrowingWithIdsDto = new BorrowingWithIdsDto();
            borrowingWithIdsDto.id = this.id;
            borrowingWithIdsDto.borrowDate = this.borrowDate;
            borrowingWithIdsDto.returnUntilDate = this.returnUntilDate;
            borrowingWithIdsDto.bookId = this.bookId;
            borrowingWithIdsDto.readerId = this.readerId;
            return borrowingWithIdsDto;
        }
    }
}
