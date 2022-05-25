package com.example.paymybuddy.controller;

import com.example.paymybuddy.model.Bank;
import com.example.paymybuddy.model.Transaction;
import com.example.paymybuddy.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {

/*    @Autowired
    private TransactionService transactionService;*/

   /* @GetMapping(value = "/user")
    public void getAll() {
        transactionService.getAllTransactions();
    }

    @PostMapping(value = "/user")
    public void addTransaction(@RequestBody Transaction transaction) {
        transactionService.addTransaction(transaction);
    }*/
}
