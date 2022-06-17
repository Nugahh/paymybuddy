package com.example.paymybuddy.DTO;

import javax.persistence.Column;

public class TransactionDTO {

    private String senderId;
    private String receiverId;
    private double amount;
    private String description;

    public TransactionDTO(){
    }

    public TransactionDTO(String senderId, String receiverId, double amount, String description) {
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.amount = amount;
        this.description = description;
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
