package com.swietlicki.library.controller.exception.borrowingException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class BookIsBorrowedAdvice {

    @ResponseBody
    @ExceptionHandler(BookIsBorrowedException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public String bookIsBorrowedHandler(BookIsBorrowedException ex) { return ex.getMessage(); }
}