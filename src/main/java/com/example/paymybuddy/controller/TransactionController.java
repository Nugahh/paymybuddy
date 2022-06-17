package com.example.paymybuddy.controller;

import com.example.paymybuddy.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping(value = "/sendMoney")
    public String addFriend(@RequestParam("friendEmail") String email,
                            @RequestParam("amount") Double amount,
                            @RequestParam("description") String description) {
        transactionService.sendMoney(email, amount, description);
        return "redirect:/home";
    }
}
