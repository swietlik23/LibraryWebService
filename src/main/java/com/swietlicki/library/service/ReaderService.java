package com.swietlicki.library.service;

import com.swietlicki.library.model.Reader;
import com.swietlicki.library.repository.ReaderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReaderService {

    private final ReaderRepository readerRepository;

    public Reader getSingleReader(long id) {
        return readerRepository.findById(id).orElseThrow();
    }

    public Reader addReader(Reader reader) {
        return readerRepository.save(reader);
    }

    public Reader updateReader(Reader reader) {
        return readerRepository.save(reader);
    }

    public void deleteReader(long id) {
        readerRepository.deleteById(id);
    }
}
