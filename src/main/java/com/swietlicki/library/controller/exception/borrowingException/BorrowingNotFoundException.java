package com.swietlicki.library.controller.exception.borrowingException;

public class BorrowingNotFoundException extends RuntimeException{

    public BorrowingNotFoundException(long id) {
        super("Could not find borrowing with id: " + id);
    }

}
