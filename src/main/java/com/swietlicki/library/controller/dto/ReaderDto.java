package com.swietlicki.library.controller.dto;

import java.util.List;

public class ReaderDto {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private List<BorrowingDto> borrowings;

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public List<BorrowingDto> getBorrowings() {
        return borrowings;
    }

    public static final class ReaderDtoBuilder {
        private long id;
        private String firstName;
        private String lastName;
        private String email;
        private List<BorrowingDto> borrowings;

        private ReaderDtoBuilder() {
        }

        public static ReaderDtoBuilder aReaderDto() {
            return new ReaderDtoBuilder();
        }

        public ReaderDtoBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public ReaderDtoBuilder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public ReaderDtoBuilder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public ReaderDtoBuilder withEmail(String email) {
            this.email = email;
            return this;
        }

        public ReaderDtoBuilder withBorrowings(List<BorrowingDto> borrowings) {
            this.borrowings = borrowings;
            return this;
        }

        public ReaderDto build() {
            ReaderDto readerDto = new ReaderDto();
            readerDto.id = this.id;
            readerDto.firstName = this.firstName;
            readerDto.lastName = this.lastName;
            readerDto.email = this.email;
            readerDto.borrowings = this.borrowings;
            return readerDto;
        }


    }
}
