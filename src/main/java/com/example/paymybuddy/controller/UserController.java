package com.example.paymybuddy.controller;

import com.example.paymybuddy.model.Transaction;
import com.example.paymybuddy.model.User;
import com.example.paymybuddy.service.TransactionService;
import com.example.paymybuddy.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @PutMapping(value = "/addFriend/{sender}/{receiver}")
    public ResponseEntity addFriend(@PathVariable Long sender, @PathVariable Long receiver){
        // If one user doesn't exist, return bad request
        LOGGER.info("test");
        if (userService.getUserById(sender).isEmpty() || userService.getUserById(receiver).isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        User fromUser = userService.getUserById(sender).get();
        User toUser = userService.getUserById(receiver).get();
        if (!fromUser.getFriends().contains(toUser)){
            userService.addFriend(fromUser, toUser);
            LOGGER.info("Add friend success");
            return ResponseEntity.status(201).build();
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

  /*  @GetMapping(value = "/getallusers")
    public void getAll() {
        userService.getAllUsers();
    }*/
/*
    @PostMapping(value = "/user")
    public void addTransaction(@RequestBody User user) {
        userService.addUser(user);
    }*/
}