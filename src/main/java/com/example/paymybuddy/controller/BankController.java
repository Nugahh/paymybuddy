package com.example.paymybuddy.controller;

import com.example.paymybuddy.DTO.BankAccountDTO;
import com.example.paymybuddy.model.Bank;
import com.example.paymybuddy.repository.BankRepository;
import com.example.paymybuddy.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class BankController {

    @Autowired
    private BankService bankService;

    @GetMapping(value = "/addBank")
    public String addFriend(@ModelAttribute("bank") BankAccountDTO bankAccountDTO) {
        bankService.addBank(bankAccountDTO);
        return "redirect:/home";
    }

    @GetMapping(value = "/addBalance")
    public String addBalance (@RequestParam("amount") Double amount){
        bankService.addBalance(amount);
        return "redirect:/home";
    }

    @GetMapping(value = "/transferMoney")
    public String transferMoney(@RequestParam("amount") Double amount){
        bankService.transferMoney(amount);
        return "redirect:/home";
    }
}

