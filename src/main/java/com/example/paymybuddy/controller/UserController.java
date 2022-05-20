package com.example.paymybuddy.controller;

import com.example.paymybuddy.model.Transaction;
import com.example.paymybuddy.model.User;
import com.example.paymybuddy.service.TransactionService;
import com.example.paymybuddy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public void getAll() {
        userService.getAllUsers();
    }

    @PostMapping(value = "/user")
    public void addTransaction(@RequestBody User user) {
        userService.addUser(user);
    }
}
