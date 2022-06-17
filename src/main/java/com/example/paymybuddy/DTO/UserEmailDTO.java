package com.example.paymybuddy.DTO;

public class UserEmailDTO {

    private String email;

    public UserEmailDTO(){
    }

    public UserEmailDTO(String email){
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
