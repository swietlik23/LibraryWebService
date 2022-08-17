package com.swietlicki.library.controller.exception.readerException;

public class ReaderEmailTakenException extends RuntimeException{

    public ReaderEmailTakenException(String email) {
        super("Email " + email + " taken");
    }

}