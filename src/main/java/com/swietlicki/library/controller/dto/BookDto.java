package com.swietlicki.library.controller.dto;

public class BookDto {

    private long id;
    private String title;
    private String authors;
    private String language_code;
    private int num_pages;
    private String publication_date;
    private String publisher;
    private BorrowingDatesDto borrowing;

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthors() {
        return authors;
    }

    public String getLanguage_code() {
        return language_code;
    }

    public int getNum_pages() {
        return num_pages;
    }

    public String getPublication_date() {
        return publication_date;
    }

    public String getPublisher() {
        return publisher;
    }

    public BorrowingDatesDto getBorrowing() {
        return borrowing;
    }

    public static final class BookDtoBuilder {
        private long id;
        private String title;
        private String authors;
        private String language_code;
        private int num_pages;
        private String publication_date;
        private String publisher;
        private BorrowingDatesDto borrowing;

        private BookDtoBuilder() {
        }

        public static BookDtoBuilder aBookDto() {
            return new BookDtoBuilder();
        }

        public BookDtoBuilder withId(long id) {
            this.id = id;
            return this;
        }

        public BookDtoBuilder withTitle(String title) {
            this.title = title;
            return this;
        }

        public BookDtoBuilder withAuthors(String authors) {
            this.authors = authors;
            return this;
        }

        public BookDtoBuilder withLanguage_code(String language_code) {
            this.language_code = language_code;
            return this;
        }

        public BookDtoBuilder withNum_pages(int num_pages) {
            this.num_pages = num_pages;
            return this;
        }

        public BookDtoBuilder withPublication_date(String publication_date) {
            this.publication_date = publication_date;
            return this;
        }

        public BookDtoBuilder withPublisher(String publisher) {
            this.publisher = publisher;
            return this;
        }

        public BookDtoBuilder withBorrowingDto(BorrowingDatesDto borrowingDatesDto) {
            this.borrowing = borrowingDatesDto;
            return this;
        }

        public BookDto build() {
            BookDto bookDto = new BookDto();
            bookDto.language_code = this.language_code;
            bookDto.authors = this.authors;
            bookDto.title = this.title;
            bookDto.num_pages = this.num_pages;
            bookDto.publication_date = this.publication_date;
            bookDto.id = this.id;
            bookDto.borrowing = this.borrowing;
            bookDto.publisher = this.publisher;
            return bookDto;
        }
    }
}
