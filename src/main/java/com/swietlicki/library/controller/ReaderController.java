package com.swietlicki.library.controller;

import com.swietlicki.library.controller.dto.readerDto.ReaderDto;
import com.swietlicki.library.controller.dto.readerDto.ReaderPostDto;
import com.swietlicki.library.controller.exception.readerException.ReaderNotFoundException;
import com.swietlicki.library.service.ReaderService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static com.swietlicki.library.controller.mapper.ReaderDtoMapper.*;

@RestController
@RequiredArgsConstructor
public class ReaderController {

    private static final Long EMPTY_ID = null;
    private final ReaderService readerService;

    @ApiOperation(value = "Find reader by id")
    @GetMapping("/readers/{id}")
    public ReaderDto getSingleUser(@ApiParam(value = "Type unique id of reader", example = "1")
                                       @PathVariable long id) {
        return mapReaderToReaderDto(readerService.getSingleReader(id).orElseThrow(()-> new ReaderNotFoundException(id)));
    }

    @ApiOperation(value = "Add new reader")
    @PostMapping("/readers")
    public ReaderPostDto addReader(@RequestBody ReaderPostDto readerPostDto) {
        return mapReaderToReaderPostDto(readerService.addReader(mapReaderPostDtoToReader(EMPTY_ID, readerPostDto)));
    }

    @ApiOperation(value = "Update reader fields or add reader if reader with the id does not exist")
    @PutMapping("/readers/{id}/edit")
    public ReaderPostDto updateReader(@ApiParam(value = "Type unique id of reader", example = "1")
                                          @PathVariable Long id, @RequestBody ReaderPostDto readerPostDto) {
        return mapReaderToReaderPostDto(readerService.updateReader(mapReaderPostDtoToReader(id, readerPostDto)));
    }

    @ApiOperation(value = "Delete reader")
    @DeleteMapping("/readers/{id}")
    public void deleteReader(@ApiParam(value = "Type unique id of reader", example = "1")
                                 @PathVariable long id) {
        readerService.deleteReader(id);
    }



}
