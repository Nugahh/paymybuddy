package com.example.paymybuddy.controller;

import com.example.paymybuddy.model.Bank;
import com.example.paymybuddy.repository.BankRepository;
import com.example.paymybuddy.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankController {

   /* private final BankService bankService;

    @Autowired
    public BankController(BankService bankService) {
        this.bankService = bankService;
    }*/

/*    @GetMapping
    public void getAll() {
        bankService.getAllBanks();
    }

    @PostMapping(value = "/bank")
    public void registerBank(@RequestBody Bank bank) {
        bankService.addBank(bank);
    }*/
}
