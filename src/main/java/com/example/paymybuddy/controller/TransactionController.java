package com.example.paymybuddy.controller;

import com.example.paymybuddy.DTO.TransactionDTO;
import com.example.paymybuddy.model.Transaction;
import com.example.paymybuddy.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Controller
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping(value = "/transfer")
    public String showTransactions(Model model, Principal principal){
        String userEmail = principal.getName();
        Optional<Transaction> transactions = transactionService.getUserTransactions();

        model.addAttribute("transactions", transactions);
        return "transaction";
    }

 /*   @GetMapping(value = "/sendMoney")
    public String sendMoney(@ModelAttribute("transaction") TransactionDTO transactionDTO) {
        transactionService.sendMoney(transactionDTO);
        return "transaction";
    }*/

    @ModelAttribute("transaction")
    public TransactionDTO userTransactionDTO(){
        return new TransactionDTO();
    }

    @GetMapping("/sendMoney")
    public String sendMoney(@ModelAttribute("transaction")TransactionDTO transactionDTO) {
        transactionService.sendMoney(transactionDTO);
        return "transaction";
    }

    /*@RequestMapping(value = "/transfer")
    public ModelAndView getTransactions() {
        ModelAndView modelAndView = new ModelAndView();
//        Iterable<TransactionDTO> list = new ArrayList<>();
        Iterable<TransactionDTO> transactions = list.forEach();
        try {
            transactions = transactionService.getTransactions();
            modelAndView.setViewName("transactionResults");
        } catch (Exception e) {
            e.printStackTrace();
            modelAndView.setViewName("error");
        }
        modelAndView.addObject("transactions", transactions);
        return modelAndView;
    }*/

   /* @GetMapping(value = "/transactions")
    public String listTransactions(Model model) {
        Iterable<Transaction> transactions = transactionService.getTransactions();

        model.addAttribute("transactions", transactions);

        return "redirect:/transaction";
    }*/
}
