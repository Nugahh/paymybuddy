package com.example.paymybuddy.repository;

import com.example.paymybuddy.model.Bank;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepository extends CrudRepository<Bank, Integer> {
}
