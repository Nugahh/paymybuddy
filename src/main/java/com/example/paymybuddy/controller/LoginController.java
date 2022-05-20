package com.example.paymybuddy.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.security.RolesAllowed;

@RestController
public class LoginController {

    @GetMapping("/login")
    @RolesAllowed("ADMIN")
    public String getAdmin() {
        return "login";
    }
}
