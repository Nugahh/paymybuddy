package com.example.paymybuddy.controller;

import com.example.paymybuddy.DTO.TransactionDTO;
import com.example.paymybuddy.model.Transaction;
import com.example.paymybuddy.model.User;
import com.example.paymybuddy.service.TransactionService;
import com.example.paymybuddy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
    private UserService userService;

    @GetMapping(value = "/transfer")
    public String showTransactions(Model model){
        List<Transaction> transactions = transactionService.getTransactions();

        model.addAttribute("transactions", transactions);
        return "transaction";
    }

    @GetMapping("/sendMoney")
    public String sendMoney(String friendEmail, Double amount, String description) {
        TransactionDTO transactionDTO = new TransactionDTO();
        transactionDTO.setReceiverId(friendEmail);
        transactionDTO.setAmount(amount);
        transactionDTO.setDescription(description);
        transactionService.sendMoney(transactionDTO);
        return "redirect:/transfer";
    }
}
  /*  public String send(String email, String message, BigDecimal number,
                       Model model, Principal principal, RedirectAttributes redirAttrs)*/
     /*   if(amount.compareTo(BigDecimal.ZERO) < 1)
        {
            redirAttrs.addFlashAttribute("errorNegative", "Negative amount error");
            return sendRedirect;
        }*/


/*<form th:action="@{/sendMoney}" method="post" th:object="${transaction}">
<div class="input-group input-group-sm mb-3">
<span class="input-group-text col-3 justify-content-center" th:text="${user.balance}"></span>
<span class="input-group-text"> € </span>
<input type="text" class="form-control" name="number" placeholder="1.00" required>
<span class="input-group-text"> -0.5% fee will be deducted </span>
<div class="input-group input-group-sm mb-3">
<span class="input-group-text col-3 justify-content-center"> Friends</span>
<select class="form-select form-select-sm" name="email" required>
<option selected th:value="email" > Select friend to send money... </option>
<option th:each="user: ${friend}" th:text="${user.firstname}+' '+${user.lastname}+': '+${user.balance}+€" th:value="${user.email}"> </option>
</select>
</div>
<div class="input-group input-group-sm mb-3">
<span class="input-group-text col-3 justify-content-center"> Message </span>
<textarea class="form-control" name="message" placeholder="Write your message..." required></textarea>
</div>
<!-- Send money button -->
<div class="d-grid gap-2 col-3 mx-auto">
<input class="form-control btn btn-success btn-sm" type="submit" name="sendMoney" value="Send money">
</div>
</form>*/

