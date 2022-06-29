package com.example.paymybuddy.DTO;

import javax.persistence.Column;
import java.time.LocalDate;

public class TransactionDTO {

    private String senderId;
    private String receiverId;
    private double amount;
    private String description;
    private LocalDate date;

    public TransactionDTO(){
    }

    public TransactionDTO(String senderId, String receiverId, double amount, String description, LocalDate date) {
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.amount = amount;
        this.description = description;
        this.date = date;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(String receiverId) {
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
}
