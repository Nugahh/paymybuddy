package com.example.paymybuddy.repository;

import com.example.paymybuddy.model.Bank;
import com.example.paymybuddy.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BankRepository extends CrudRepository<Bank, Integer> {

    Optional<Bank> findByUser(User user);

}
