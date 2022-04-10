package com.swietlicki.library.controller.exception.readerException;

public class ReaderNotFoundException extends RuntimeException{

    public ReaderNotFoundException(long id) {
        super("Could not find reader with id: " + id);
    }

}
