package com.swietlicki.library.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class FinancialTransaction {

    public static final double FEE_PER_DAY = 0.5;
    public enum FinancialType {
        FEE, INCOMING_TRANSFER
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private FinancialType transferType;
    private LocalDateTime created;
    private long readerId;
    private String description;
    private double amount;

}
