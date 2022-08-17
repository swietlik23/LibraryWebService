package com.swietlicki.library.controller.exception.borrowingException;

public class BookIsBorrowedException extends RuntimeException{

    public BookIsBorrowedException(long bookId, long borrowingId) {
        super("The book id: " + bookId + " is borrowed. The borrowing id: " + borrowingId);
    }

}