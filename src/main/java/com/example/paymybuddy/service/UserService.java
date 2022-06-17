package com.example.paymybuddy.service;

import com.example.paymybuddy.DTO.UserRegistrationDTO;
import com.example.paymybuddy.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserService extends UserDetailsService {

    void save(UserRegistrationDTO registrationDTO);

    void addFriend(String friendEmail);

    Iterable<User> getAllUsers();

    Optional<User> getUserByEmail(String email);

    Optional<User> getUserById(Long id);

    void deleteById(Long id);
}
