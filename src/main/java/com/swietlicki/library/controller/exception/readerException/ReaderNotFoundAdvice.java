package com.swietlicki.library.controller.exception.readerException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ReaderNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(ReaderNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String readerNotFoundHandler(ReaderNotFoundException ex) { return ex.getMessage(); }
}
