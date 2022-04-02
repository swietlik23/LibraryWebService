package com.swietlicki.library.controller.dto;

public class BookDetailsDto {

    private long id;
    private String title;
    private String authors;
    private String language_code;
    private int num_pages;
    private String publication_date;
    private String publisher;

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


    public static final class BookDetailsDtoBuilder {
        private long id;
        private String title;
        private String authors;
        private String language_code;
        private int num_pages;
        private String publication_date;
        private String publisher;

        private BookDetailsDtoBuilder() {
        }

        public static BookDetailsDtoBuilder aBookDetailsDto() {
            return new BookDetailsDtoBuilder();
        }

        public BookDetailsDtoBuilder withId(long id) {
            this.id = id;
            return this;
        }

        public BookDetailsDtoBuilder withTitle(String title) {
            this.title = title;
            return this;
        }

        public BookDetailsDtoBuilder withAuthors(String authors) {
            this.authors = authors;
            return this;
        }

        public BookDetailsDtoBuilder withLanguage_code(String language_code) {
            this.language_code = language_code;
            return this;
        }

        public BookDetailsDtoBuilder withNum_pages(int num_pages) {
            this.num_pages = num_pages;
            return this;
        }

        public BookDetailsDtoBuilder withPublication_date(String publication_date) {
            this.publication_date = publication_date;
            return this;
        }

        public BookDetailsDtoBuilder withPublisher(String publisher) {
            this.publisher = publisher;
            return this;
        }

        public BookDetailsDto build() {
            BookDetailsDto bookDetailsDto = new BookDetailsDto();
            bookDetailsDto.title = this.title;
            bookDetailsDto.publisher = this.publisher;
            bookDetailsDto.num_pages = this.num_pages;
            bookDetailsDto.language_code = this.language_code;
            bookDetailsDto.authors = this.authors;
            bookDetailsDto.publication_date = this.publication_date;
            bookDetailsDto.id = this.id;
            return bookDetailsDto;
        }
    }
}
