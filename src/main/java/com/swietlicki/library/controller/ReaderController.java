package com.swietlicki.library.controller;

import com.swietlicki.library.controller.dto.readerDto.ReaderDto;
import com.swietlicki.library.controller.dto.readerDto.ReaderPostDto;
import com.swietlicki.library.service.ReaderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static com.swietlicki.library.controller.mapper.ReaderDtoMapper.*;

@RestController
@RequiredArgsConstructor
public class ReaderController {

    private static final Long EMPTY_ID = null;
    private final ReaderService readerService;

    @GetMapping("/readers/{id}")
    public ReaderDto getSingleUser(@PathVariable long id) {
        return mapReaderToReaderDto(readerService.getSingleReader(id));
    }

    @PostMapping("/readers")
    public ReaderPostDto addReader(@RequestBody ReaderPostDto readerPostDto) {
        return mapReaderToReaderPostDto(readerService.addReader(mapReaderPostDtoToReader(EMPTY_ID, readerPostDto)));
    }

    @PutMapping("/readers/{id}/edit")
    public ReaderPostDto updateReader(@PathVariable Long id, @RequestBody ReaderPostDto readerPostDto) {
        return mapReaderToReaderPostDto(readerService.updateReader(mapReaderPostDtoToReader(id, readerPostDto)));
    }

    @DeleteMapping("/readers/{id}")
    public void deleteReader(@PathVariable long id) {
        readerService.deleteReader(id);
    }



}
