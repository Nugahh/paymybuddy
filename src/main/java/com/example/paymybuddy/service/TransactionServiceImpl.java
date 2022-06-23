package com.example.paymybuddy.service;

import com.example.paymybuddy.DTO.TransactionDTO;
import com.example.paymybuddy.model.Transaction;
import com.example.paymybuddy.model.User;
import com.example.paymybuddy.repository.TransactionRepository;
import com.example.paymybuddy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void sendMoney(TransactionDTO transactionDTO){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User currentUser = userRepository.findByEmail(username);

        User friend = userRepository.findByEmail(transactionDTO.getReceiverId());
        System.out.println(transactionDTO.getReceiverId());
        Transaction transaction = new Transaction(currentUser.getUserId(), friend.getUserId(),
                LocalDate.now(), transactionDTO.getAmount(), transactionDTO.getDescription());
        currentUser.setBalance(currentUser.getBalance() - (transactionDTO.getAmount() + (transactionDTO.getAmount() * 0.005)));
        friend.setBalance(friend.getBalance() + transactionDTO.getAmount());

        transactionRepository.save(transaction);
    }

    @Override
    public List<Transaction> getTransactions() {
        return transactionRepository.findAll();
    }

    public Optional<Transaction> getUserTransactions(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User currentUser = userRepository.findByEmail(username);

        return (transactionRepository.findByEmail(username));
    }
}


