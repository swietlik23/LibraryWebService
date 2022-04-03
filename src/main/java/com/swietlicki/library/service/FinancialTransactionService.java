package com.swietlicki.library.service;

import com.swietlicki.library.model.FinancialTransaction;
import com.swietlicki.library.repository.FinancialTransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FinancialTransactionService {

    private final FinancialTransactionRepository financialTransactionRepository;

    public FinancialTransaction addTransaction(FinancialTransaction financialTransaction) {
        return financialTransactionRepository.save(financialTransaction);
    }
}
