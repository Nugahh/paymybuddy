package com.example.paymybuddy.service;

import com.example.paymybuddy.DTO.UserRegistrationDTO;
import com.example.paymybuddy.model.User;
import com.example.paymybuddy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserService extends UserDetailsService {

    void save(UserRegistrationDTO registrationDTO);

    void addFriend(User user, User friend);

    Iterable<User> getAllUsers();

    Optional<User> getUserByEmail(String email);

    Optional<User> getUserById(Long id);

    void deleteById(Long id);
}
