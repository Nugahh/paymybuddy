package com.example.paymybuddy.model;

import javax.persistence.*;

@Entity
@Table(name = "bank")
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bankId;

    @Column(name = "account_number")
    private int accountNumber;

    @Column(name = "bank_name")
    private String bankName;

    @Column
    private double amount;
}
