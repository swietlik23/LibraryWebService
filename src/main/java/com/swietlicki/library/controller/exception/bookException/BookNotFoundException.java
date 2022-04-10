package com.swietlicki.library.controller.exception.bookException;

public class BookNotFoundException extends RuntimeException{

    public BookNotFoundException(long id) {
        super("Could not find book with id: " + id);
    }

}
