package com.example.paymybuddy.controller;

import com.example.paymybuddy.model.Bank;
import com.example.paymybuddy.model.Transaction;
import com.example.paymybuddy.model.User;
import com.example.paymybuddy.repository.UserRepository;
import com.example.paymybuddy.service.TransactionService;
import com.example.paymybuddy.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
            private UserRepository userRepository;

    Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @GetMapping(value = "/")
    public String showHome(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User currentUser = userRepository.findByEmail(username);
        Double balance = currentUser.getBalance();

        model.addAttribute("balance", balance);
        return "home";
    }

    @GetMapping(value = "/addFriend")
    public String addFriend(@RequestParam("friendEmail") String email){
        userService.addFriend(email);
        return "redirect:/contact";
    }

    @GetMapping(value = "/contact")
    public String showTransactions(Model model){
        Set<User> users = userService.getUsers();

        model.addAttribute("users", users);
        return "contact";
    }
}