package com.swietlicki.library.controller.dto.financialTransactionDto;

import java.time.LocalDateTime;

public class FinancialTransactionDto {

    private LocalDateTime created;
    private long readerId;
    private String description;
    private double amount;

    public LocalDateTime getCreated() {
        return created;
    }

    public long getReaderId() {
        return readerId;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    public static final class FinancialTransactionDtoBuilder {
        private LocalDateTime created;
        private long readerId;
        private String description;
        private double amount;

        private FinancialTransactionDtoBuilder() {
        }

        public static FinancialTransactionDtoBuilder aFinancialTransactionDto() {
            return new FinancialTransactionDtoBuilder();
        }

        public FinancialTransactionDtoBuilder withCreated(LocalDateTime created) {
            this.created = created;
            return this;
        }

        public FinancialTransactionDtoBuilder withReaderId(long readerId) {
            this.readerId = readerId;
            return this;
        }

        public FinancialTransactionDtoBuilder withDescription(String description) {
            this.description = description;
            return this;
        }

        public FinancialTransactionDtoBuilder withAmount(double amount) {
            this.amount = amount;
            return this;
        }

        public FinancialTransactionDto build() {
            FinancialTransactionDto financialTransactionDto = new FinancialTransactionDto();
            financialTransactionDto.created = this.created;
            financialTransactionDto.amount = this.amount;
            financialTransactionDto.readerId = this.readerId;
            financialTransactionDto.description = this.description;
            return financialTransactionDto;
        }
    }
}
