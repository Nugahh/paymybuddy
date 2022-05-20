package com.example.paymybuddy.service;

import com.example.paymybuddy.model.Bank;
import com.example.paymybuddy.model.User;
import com.example.paymybuddy.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BankService {

    @Autowired
    private BankRepository bankRepository;

    public Iterable<Bank> getAllBanks() {
        return bankRepository.findAll();
    }

    public Optional<Bank> getBankById(Integer id) {
        return bankRepository.findById(id);
    }

    public Bank addBank(Bank bank) {
        return bankRepository.save(bank);
    }

    public Optional<Bank> getBankByUser(User user) {
        return bankRepository.findByUser(user);
    }
}
