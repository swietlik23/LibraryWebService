package com.swietlicki.library.controller.exception.readerException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ReaderEmailTakenAdvice {

    @ResponseBody
    @ExceptionHandler(ReaderEmailTakenException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String readerEmailTakenHandler(ReaderEmailTakenException ex) {return ex.getMessage();}
}
