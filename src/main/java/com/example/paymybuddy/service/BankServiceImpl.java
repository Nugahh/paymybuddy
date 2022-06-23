package com.example.paymybuddy.service;

import com.example.paymybuddy.DTO.BankAccountDTO;
import com.example.paymybuddy.model.Bank;
import com.example.paymybuddy.model.User;
import com.example.paymybuddy.repository.BankRepository;
import com.example.paymybuddy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class BankServiceImpl implements BankService{

    @Autowired
    private BankRepository bankRepository;

    @Autowired
    private UserRepository userRepository;

    public void addBank(BankAccountDTO bankAccountDTO){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User currentUser = userRepository.findByEmail(username);

        Bank bank = new Bank(currentUser.getUserId(), bankAccountDTO.getBankName(), bankAccountDTO.getIban(),
                bankAccountDTO.getBic());

        bankRepository.save(bank);
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

        currentUser.setBalance(currentUser.getBalance() - amount);
        userRepository.save(currentUser);
    }
}
