package com.swietlicki.library.controller;

import com.swietlicki.library.model.Reader;
import com.swietlicki.library.service.ReaderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ReaderController {

    private final ReaderService readerService;

    @GetMapping("/readers/{id}")
    public Reader getSingleUser(@PathVariable long id) {
        return readerService.getSingleReader(id);
    }

    @PostMapping("/readers")
    public Reader addReader(@RequestBody Reader reader) {
        return readerService.addReader(reader);
    }

}
