package com.swietlicki.library.controller.dto.bookDto;

public class BookPostDto {

    private String title;
    private String authors;
    private String language_code;
    private int num_pages;
    private String publication_date;
    private String publisher;

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

    public static final class BookPostDtoBuilder {
        private String title;
        private String authors;
        private String language_code;
        private int num_pages;
        private String publication_date;
        private String publisher;

        private BookPostDtoBuilder() {
        }

        public static BookPostDtoBuilder aBookPostDto() {
            return new BookPostDtoBuilder();
        }

        public BookPostDtoBuilder withTitle(String title) {
            this.title = title;
            return this;
        }

        public BookPostDtoBuilder withAuthors(String authors) {
            this.authors = authors;
            return this;
        }

        public BookPostDtoBuilder withLanguage_code(String language_code) {
            this.language_code = language_code;
            return this;
        }

        public BookPostDtoBuilder withNum_pages(int num_pages) {
            this.num_pages = num_pages;
            return this;
        }

        public BookPostDtoBuilder withPublication_date(String publication_date) {
            this.publication_date = publication_date;
            return this;
        }

        public BookPostDtoBuilder withPublisher(String publisher) {
            this.publisher = publisher;
            return this;
        }

        public BookPostDto build() {
            BookPostDto bookPostDto = new BookPostDto();
            bookPostDto.authors = this.authors;
            bookPostDto.num_pages = this.num_pages;
            bookPostDto.publisher = this.publisher;
            bookPostDto.language_code = this.language_code;
            bookPostDto.publication_date = this.publication_date;
            bookPostDto.title = this.title;
            return bookPostDto;
        }
    }
}
