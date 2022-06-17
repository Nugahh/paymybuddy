package com.example.paymybuddy.service;

import com.example.paymybuddy.DTO.BankAccountDTO;
import org.springframework.stereotype.Service;

@Service
public interface BankService {

    void addBank(BankAccountDTO bankAccountDTO);

    void addBalance(Double amount);

    void transferMoney(Double amount);
}
