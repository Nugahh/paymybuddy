package com.example.paymybuddy.repository;

import com.example.paymybuddy.model.Bank;
import com.example.paymybuddy.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BankRepository extends JpaRepository<Bank, Integer> {

//    Optional<Bank> findByUser(User user);

}
