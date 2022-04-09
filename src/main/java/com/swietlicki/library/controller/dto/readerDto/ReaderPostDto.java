package com.swietlicki.library.controller.dto.readerDto;

public class ReaderPostDto {
    private String firstName;
    private String lastName;
    private String email;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public static final class ReaderPostDtoBuilder {
        private String firstName;
        private String lastName;
        private String email;

        private ReaderPostDtoBuilder() {
        }

        public static ReaderPostDtoBuilder aReaderPostDto() {
            return new ReaderPostDtoBuilder();
        }

        public ReaderPostDtoBuilder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public ReaderPostDtoBuilder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public ReaderPostDtoBuilder withEmail(String email) {
            this.email = email;
            return this;
        }

        public ReaderPostDto build() {
            ReaderPostDto readerPostDto = new ReaderPostDto();
            readerPostDto.email = this.email;
            readerPostDto.lastName = this.lastName;
            readerPostDto.firstName = this.firstName;
            return readerPostDto;
        }
    }
}
