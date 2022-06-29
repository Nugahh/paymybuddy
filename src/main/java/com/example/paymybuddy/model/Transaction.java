package com.example.paymybuddy.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
public class Transaction {

    public Transaction() {
    }

    public Transaction(Long senderId, Long receiverId, LocalDate date, double amount, String description) {
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.date = date;
        this.amount = amount;
        this.description = description;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

   /* public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }*/

    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long receiverId) {
    }

    public Long getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Long receiverId) {
        this.receiverId = receiverId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;

    @Column
    private LocalDate date;

  /*  @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "senderId", referencedColumnName = "transactionId")
    private User sender;*/

    @Column
    private Long senderId;

    @Column
    private Long receiverId;

    @Column
    private double amount;

    @Column
    private String description;
}
