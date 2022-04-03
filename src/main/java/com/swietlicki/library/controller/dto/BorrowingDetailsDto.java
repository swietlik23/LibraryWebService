package com.swietlicki.library.controller.dto;

import java.time.LocalDateTime;

public class BorrowingDetailsDto {

    private long id;
    private LocalDateTime borrowDate;
    private LocalDateTime returnUntilDate;

    public long getId() {
        return id;
    }

    public LocalDateTime getBorrowDate() {
        return borrowDate;
    }

    public LocalDateTime getReturnUntilDate() {
        return returnUntilDate;
    }

    public static final class BorrowingDtoBuilder {
        private long id;
        private LocalDateTime borrowDate;
        private LocalDateTime returnUntilDate;

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

        public BorrowingDtoBuilder withReturnUntilDate(LocalDateTime returnUntilDate) {
            this.returnUntilDate = returnUntilDate;
            return this;
        }

        public BorrowingDetailsDto build() {
            BorrowingDetailsDto borrowingDetailsDto = new BorrowingDetailsDto();
            borrowingDetailsDto.id = this.id;
            borrowingDetailsDto.borrowDate = this.borrowDate;
            borrowingDetailsDto.returnUntilDate = this.returnUntilDate;
            return borrowingDetailsDto;
        }
    }
}
