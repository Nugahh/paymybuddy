package com.example.paymybuddy.controller;

import com.example.paymybuddy.DTO.BankAccountDTO;
import com.example.paymybuddy.model.Bank;
import com.example.paymybuddy.model.Transaction;
import com.example.paymybuddy.model.User;
import com.example.paymybuddy.repository.BankRepository;
import com.example.paymybuddy.repository.UserRepository;
import com.example.paymybuddy.service.BankService;
import com.example.paymybuddy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
public class BankController {

    @Autowired
    private BankService bankService;

    @Autowired
    private UserRepository userRepository;


    @GetMapping(value = "/profile")
    public String showTransactions(Model model){
        Bank bank = bankService.getBank();

        model.addAttribute("bank", bank);
        return "profile";
    }

    @GetMapping(value = "/addBank")
    public String addBank(@ModelAttribute("bank") BankAccountDTO bankAccountDTO) {
        bankService.addBank(bankAccountDTO);
        return "redirect:/profile";
    }

    @GetMapping(value = "/addBalance")
    public String addBalance (@RequestParam("amount") Double amount){
        bankService.addBalance(amount);
        return "redirect:/home";
    }

    @GetMapping(value = "/transferMoney")
    public String transferMoney(@RequestParam("amount") Double amount) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User currentUser = userRepository.findByEmail(username);

        if (currentUser.getBalance() - amount >= 0)
        {
            bankService.transferMoney(amount);
            return "redirect:home";
        }
        else
            return "redirect:/home?error";
    }
}

