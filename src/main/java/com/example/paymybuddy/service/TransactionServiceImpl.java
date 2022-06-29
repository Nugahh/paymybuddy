package com.example.paymybuddy.service;

import com.example.paymybuddy.DTO.TransactionDTO;
import com.example.paymybuddy.controller.UserController;
import com.example.paymybuddy.model.Transaction;
import com.example.paymybuddy.model.User;
import com.example.paymybuddy.repository.TransactionRepository;
import com.example.paymybuddy.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private UserRepository userRepository;

    Logger LOGGER = LoggerFactory.getLogger(TransactionServiceImpl.class);

    @Transactional
    public void sendMoney(TransactionDTO transactionDTO){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User currentUser = userRepository.findByEmail(username);

        User friend = userRepository.findByEmail(transactionDTO.getReceiverId());
        Transaction transaction = new Transaction(currentUser.getUserId(), friend.getUserId(),
                LocalDate.now(), transactionDTO.getAmount(), transactionDTO.getDescription());
        if (currentUser.getBalance() - (transactionDTO.getAmount() + (transactionDTO.getAmount() * 0.005)) >= 0)
        {
            if (transactionDTO.getReceiverId().equals(transactionDTO.getSenderId()))
                LOGGER.error("You cannot send to the same account!");
            currentUser.setBalance(currentUser.getBalance() - (transactionDTO.getAmount() + (transactionDTO.getAmount() * 0.005)));
        }
        else
            LOGGER.error("Insufficient balance");
        friend.setBalance(friend.getBalance() + transactionDTO.getAmount());

        transactionRepository.save(transaction);
    }

    @Override
    public List<Transaction> getTransactions() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User currentUser = userRepository.findByEmail(username);
        List<Transaction> transactions = transactionRepository.findAll();

        return transactions.stream()
                .filter(c -> (c.getSenderId().equals(currentUser.getUserId())) ||
                        c.getReceiverId().equals(currentUser.getUserId()))
                .collect(Collectors.toList());
    }

    /*public List<Transaction> getUserTransactions(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User currentUser = userRepository.findByEmail(username);

        return (currentUser.getTransactionId());
    }*/
}


