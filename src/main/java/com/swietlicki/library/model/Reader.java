package com.swietlicki.library.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Reader {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private double balance;

    @OneToMany(mappedBy = "reader", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Borrowing> borrowings;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "readerId")
    private List<FinancialTransaction> financialTransactions;

    public void setCurrentBalance() {
        double amount = financialTransactions.stream().sequential()
                .mapToDouble(FinancialTransaction::getAmount)
                .sum();
        this.balance=amount;
    }

    public double getBalance() {
        setCurrentBalance();
        return this.balance;
    }
}
