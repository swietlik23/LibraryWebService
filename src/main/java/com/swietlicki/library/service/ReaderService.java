package com.swietlicki.library.service;

import com.swietlicki.library.controller.exception.readerException.ReaderEmailTakenException;
import com.swietlicki.library.controller.exception.readerException.ReaderNotFoundException;
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
        return readerRepository.findById(id).orElseThrow(()-> new ReaderNotFoundException(id));
    }

    public Reader addReader(Reader reader) {
        Reader existingReader = readerRepository.findByEmail(reader.getEmail());
        if (existingReader != null) {
            throw new ReaderEmailTakenException(reader.getEmail());
        }
        return readerRepository.save(reader);
    }

    public Reader updateReader(Reader reader) {
        Reader readerToEdit = readerRepository.findById(reader.getId())
                .orElseThrow(()-> new ReaderNotFoundException(reader.getId()));
        readerToEdit.setEmail(reader.getEmail());
        readerToEdit.setFirstName(reader.getFirstName());
        readerToEdit.setLastName(reader.getLastName());
        return readerRepository.save(readerToEdit);
    }

    public void deleteReader(long id) {
        if(!readerRepository.existsById(id)) {
            throw new ReaderNotFoundException(id);
        }
        readerRepository.deleteById(id);
    }

    public void updateReaderBalance(long readerId) {
        Reader reader = readerRepository.findById(readerId)
                .orElseThrow(()-> new ReaderNotFoundException(readerId));
        reader.setCurrentBalance();
        readerRepository.save(reader);
    }
}
