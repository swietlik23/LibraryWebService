package com.swietlicki.library.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class FinancialTransaction {

    public static final double FEE_PER_DAY = -0.5;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDateTime created = LocalDateTime.now();
    private long readerId;
    private String description;
    private double amount;
}
