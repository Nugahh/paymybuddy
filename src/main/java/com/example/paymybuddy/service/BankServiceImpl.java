package com.example.paymybuddy.service;

import com.example.paymybuddy.DTO.BankAccountDTO;
import com.example.paymybuddy.controller.UserController;
import com.example.paymybuddy.model.Bank;
import com.example.paymybuddy.model.Transaction;
import com.example.paymybuddy.model.User;
import com.example.paymybuddy.repository.BankRepository;
import com.example.paymybuddy.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BankServiceImpl implements BankService{

    @Autowired
    private BankRepository bankRepository;

    @Autowired
    private UserRepository userRepository;

    Logger LOGGER = LoggerFactory.getLogger(BankServiceImpl.class);

    public void addBank(BankAccountDTO bankAccountDTO){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User currentUser = userRepository.findByEmail(username);

        Bank bank = new Bank(currentUser, bankAccountDTO.getBankName(), bankAccountDTO.getIban(),
                bankAccountDTO.getBic());

        bankRepository.save(bank);
    }

    public void deleteBank(Bank bank){
        Optional<Bank> removeBank = bankRepository.findById(bank.getBankId());
        if (removeBank.isPresent())
            bankRepository.deleteById(bank.getBankId());
    }

    public void addBalance(Double amount){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User currentUser = userRepository.findByEmail(username);

        currentUser.setBalance(currentUser.getBalance() + amount);
        userRepository.save(currentUser);
    }

    public void transferMoney(Double amount){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User currentUser = userRepository.findByEmail(username);

        if (currentUser.getBalance() - amount >= 0)
            currentUser.setBalance(currentUser.getBalance() - amount);
        else {
           LOGGER.error("Insufficient balance");
           return;
        }
        userRepository.save(currentUser);
    }

    @Override
    public Bank getBank() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User currentUser = userRepository.findByEmail(username);

        return bankRepository.findByUserId(currentUser);
    }
}
