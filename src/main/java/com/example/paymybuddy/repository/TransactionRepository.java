package com.example.paymybuddy.repository;

import com.example.paymybuddy.model.Bank;
import com.example.paymybuddy.model.Transaction;
import com.example.paymybuddy.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Integer> {

    Optional<Transaction> findByUser(User user);
}
