package com.swietlicki.library.controller.mapper;

import com.swietlicki.library.controller.dto.financialTransactionDto.FinancialTransactionDto;
import com.swietlicki.library.model.FinancialTransaction;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class FinancialTransactionDtoMapper {

    public static FinancialTransaction mapFinancialTransactionDtoToFinancialTransaction(
            FinancialTransactionDto ftDto) {
        FinancialTransaction financialTransaction = new FinancialTransaction();
        financialTransaction.setAmount(ftDto.getAmount());
        financialTransaction.setDescription(ftDto.getDescription());
        financialTransaction.setReaderId(ftDto.getReaderId());
        financialTransaction.setCreated(LocalDateTime.now());
        return financialTransaction;
    }

    public static List<FinancialTransactionDto> mapFinancialTransactionsToDtos(List<FinancialTransaction> ft) {
        return ft.stream()
                .map(FinancialTransactionDtoMapper::mapFinancialTransactionToDto)
                .collect(Collectors.toList());
    }

    private static FinancialTransactionDto mapFinancialTransactionToDto(FinancialTransaction financialTransaction) {
        return FinancialTransactionDto.FinancialTransactionDtoBuilder.aFinancialTransactionDto()
                .withAmount(financialTransaction.getAmount())
                .withReaderId(financialTransaction.getReaderId())
                .withCreated(financialTransaction.getCreated())
                .withDescription(financialTransaction.getDescription())
                .build();
    }

}
