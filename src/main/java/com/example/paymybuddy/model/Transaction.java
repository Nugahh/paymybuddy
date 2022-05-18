package com.example.paymybuddy.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transactionId;

    @Column
    private LocalDateTime date;

    @Column
    private double amount;

    @Column
    private String description;
}
