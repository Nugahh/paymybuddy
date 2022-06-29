package com.example.paymybuddy.controller;

import com.example.paymybuddy.DTO.TransactionDTO;
import com.example.paymybuddy.model.Transaction;
import com.example.paymybuddy.model.User;
import com.example.paymybuddy.repository.UserRepository;
import com.example.paymybuddy.service.TransactionService;
import com.example.paymybuddy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.*;

@Controller
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping(value = "/transfer")
    public String showTransactions(Model model){
        List<Transaction> transactions = transactionService.getTransactions();

        model.addAttribute("transactions", transactions);
        return "transaction";
    }

    @GetMapping("/sendMoney")
    public String sendMoney(String friendEmail, Double amount, String description) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User currentUser = userRepository.findByEmail(username);

        TransactionDTO transactionDTO = new TransactionDTO();
        transactionDTO.setReceiverId(friendEmail);
        transactionDTO.setAmount(amount);
        transactionDTO.setDescription(description);


        if (friendEmail.equals(currentUser.getEmail()))
            return "redirect:/transfer?error";
        else if (currentUser.getBalance() - amount < 0)
            return "redirect:/transfer?errorAmount";
        else
        {
            transactionService.sendMoney(transactionDTO);
            return "redirect:/transfer";
        }
    }
}
  /*  public String send(String email, String message, BigDecimal number,
                       Model model, Principal principal, RedirectAttributes redirAttrs)*/
     /*   if(amount.compareTo(BigDecimal.ZERO) < 1)
        {
            redirAttrs.addFlashAttribute("errorNegative", "Negative amount error");
            return sendRedirect;
        }*/



