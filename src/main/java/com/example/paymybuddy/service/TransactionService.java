package com.example.paymybuddy.service;

import com.example.paymybuddy.DTO.TransactionDTO;
import com.example.paymybuddy.model.Transaction;
import com.example.paymybuddy.model.User;
import com.example.paymybuddy.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface TransactionService {

    void sendMoney(TransactionDTO transactionDTO);

    List<Transaction> getTransactions();

//    List<Transaction> getUserTransactions();
}