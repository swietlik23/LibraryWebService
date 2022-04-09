package com.swietlicki.library.service;

import com.swietlicki.library.model.Reader;
import com.swietlicki.library.repository.ReaderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

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

    @Transactional
    public Reader updateReader(Reader reader) {
        Reader readerToEdit = readerRepository.findById(reader.getId()).orElseThrow();
        readerToEdit.setEmail(reader.getEmail());
        readerToEdit.setFirstName(reader.getFirstName());
        readerToEdit.setLastName(reader.getLastName());
        return readerToEdit;
    }

    public void deleteReader(long id) {
        readerRepository.deleteById(id);
    }

    public void updateReaderBalance(long readerId) {
        Reader reader = readerRepository.getById(readerId);
        reader.setCurrentBalance();
        readerRepository.save(reader);
    }
}
