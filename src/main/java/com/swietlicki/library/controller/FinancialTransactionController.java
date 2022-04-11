package com.swietlicki.library.controller;

import com.swietlicki.library.controller.dto.financialTransactionDto.FinancialTransactionDto;
import com.swietlicki.library.controller.exception.readerException.ReaderNotFoundException;
import com.swietlicki.library.model.FinancialTransaction;
import com.swietlicki.library.model.Reader;
import com.swietlicki.library.service.FinancialTransactionService;
import com.swietlicki.library.service.ReaderService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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

    @ApiOperation(value = "Add new transaction")
    @PostMapping("/transactions")
    public void addMoney(@RequestBody FinancialTransactionDto financialTransactionDto) {
        long readerId = financialTransactionDto.getReaderId();
        Reader reader = readerService.getSingleReader(readerId).orElseThrow(
                ()-> new ReaderNotFoundException(readerId));
        FinancialTransaction ft = mapFinancialTransactionDtoToFinancialTransaction(financialTransactionDto);
        List<FinancialTransaction> transactions = reader.getFinancialTransactions();
        transactions.add(ft);
        reader.setFinancialTransactions(transactions);
        reader.setCurrentBalance();
        financialTransactionService.addTransaction(ft);
        readerService.addReader(reader);
    }

    @ApiOperation(value = "Get reader's transactions")
    @GetMapping("/reader/{readerId}/transactions/")
    public List<FinancialTransactionDto> getReaderTransactions (@ApiParam(value = "Type unique reader id",
                                                                example = "1")
                                                                    @PathVariable long readerId) {
        return mapFinancialTransactionsToDtos(financialTransactionService.getAllByReaderId(readerId));
    }

}
