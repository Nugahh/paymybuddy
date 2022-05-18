package com.example.paymybuddy.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.security.RolesAllowed;

@RestController
public class LoginController {

    @GetMapping("/*")
    @RolesAllowed("USER")
    public String getUser() {
        return "Welcome, User";
    }

    @GetMapping("/admin")
    @RolesAllowed("ADMIN")
    public String getAdmin() {
        return "Welcome, Admin";
    }
}
