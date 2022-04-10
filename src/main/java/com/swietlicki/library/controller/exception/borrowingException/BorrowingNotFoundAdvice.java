package com.swietlicki.library.controller.exception.borrowingException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class BorrowingNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(BorrowingNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String borrowingNotFoundHandler(BorrowingNotFoundException ex) { return ex.getMessage(); }
}
