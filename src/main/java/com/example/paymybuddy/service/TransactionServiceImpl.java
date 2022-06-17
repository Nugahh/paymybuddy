package com.example.paymybuddy.service;

import com.example.paymybuddy.model.Transaction;
import com.example.paymybuddy.model.User;
import com.example.paymybuddy.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.time.LocalDate;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void sendMoney(String friendEmail, Double amount, String description){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User currentUser = userRepository.findByEmail(username);

        User friend = userRepository.findByEmail(friendEmail);
        Transaction transaction = new Transaction(currentUser.getUserId(), friend.getUserId(),
                LocalDate.now(), amount, description);
        currentUser.setBalance(currentUser.getBalance() - (amount + (amount * 0.005)));
        friend.setBalance(friend.getBalance() + amount);

        transactionRepository.save(transaction);
    }
}


