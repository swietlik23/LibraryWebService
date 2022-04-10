package com.swietlicki.library.service;

import com.swietlicki.library.model.Borrowing;
import com.swietlicki.library.repository.BorrowingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BorrowingService {

    private static final int PAGE_SIZE = 15;
    private final BorrowingRepository borrowingRepository;

    public List<Borrowing> getBorrowings(int page) {
        return borrowingRepository.findAllBorrowings(PageRequest.of(page,PAGE_SIZE));
    }

    public Borrowing addBorrowing(Borrowing borrowing) {
        return borrowingRepository.save(borrowing);
    }

    public void deleteBorrowing(long id) {
        borrowingRepository.deleteById(id);
    }

    public Optional<Borrowing> getBorrowing(long id) {
        return borrowingRepository.findById(id);
    }
}
