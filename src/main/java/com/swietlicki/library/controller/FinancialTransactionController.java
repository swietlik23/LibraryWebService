package com.swietlicki.library.controller;

import com.swietlicki.library.controller.dto.financialTransactionDto.FinancialTransactionDto;
import com.swietlicki.library.model.FinancialTransaction;
import com.swietlicki.library.model.Reader;
import com.swietlicki.library.service.FinancialTransactionService;
import com.swietlicki.library.service.ReaderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.swietlicki.library.controller.mapper.FinancialTransactionDtoMapper
        .mapFinancialTransactionDtoToFinancialTransaction;
import static com.swietlicki.library.controller.mapper.FinancialTransactionDtoMapper.mapFinancialTransactionsToDtos;

@RestController
@RequiredArgsConstructor
public class FinancialTransactionController {

    private final FinancialTransactionService financialTransactionService;
    private final ReaderService readerService;

    @PostMapping("/transaction")
    public void addMoney(@RequestBody FinancialTransactionDto financialTransactionDto) {
        Reader reader = readerService.getSingleReader(financialTransactionDto.getReaderId());
        FinancialTransaction ft = mapFinancialTransactionDtoToFinancialTransaction(financialTransactionDto);
        List<FinancialTransaction> transactions = reader.getFinancialTransactions();
        transactions.add(ft);
        reader.setFinancialTransactions(transactions);
        financialTransactionService.addTransaction(ft);
        readerService.addReader(reader);
    }

    @GetMapping("/transaction/{readerId}")
    public List<FinancialTransactionDto> getReaderTransactions (@PathVariable long readerId) {
        return mapFinancialTransactionsToDtos(financialTransactionService.getAllByReaderId(readerId));
    }

}
