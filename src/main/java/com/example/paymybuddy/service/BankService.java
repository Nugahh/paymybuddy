package com.example.paymybuddy.service;

import com.example.paymybuddy.model.Bank;
import com.example.paymybuddy.model.User;
import com.example.paymybuddy.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface BankService {

  /*  @Autowired
    private BankRepository bankRepository;

    public List<Bank> getAllBanks() {
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
    }*/
}
