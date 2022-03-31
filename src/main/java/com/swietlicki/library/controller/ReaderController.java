package com.swietlicki.library.controller;

import com.swietlicki.library.controller.dto.ReaderDto;
import com.swietlicki.library.model.Reader;
import com.swietlicki.library.service.ReaderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static com.swietlicki.library.controller.mapper.ReaderToReaderDtoMapper.mapReaderToReaderDto;

@RestController
@RequiredArgsConstructor
public class ReaderController {

    private final ReaderService readerService;

    @GetMapping("/readers/{id}")
    public ReaderDto getSingleUser(@PathVariable long id) {
        return mapReaderToReaderDto(readerService.getSingleReader(id));
    }



    @PostMapping("/readers")
    public Reader addReader(@RequestBody Reader reader) {
        return readerService.addReader(reader);
    }

}
