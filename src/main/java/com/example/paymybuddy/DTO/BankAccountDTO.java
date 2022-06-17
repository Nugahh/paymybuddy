package com.example.paymybuddy.DTO;

public class BankAccountDTO {

    private String bankName;
    private String iban;
    private String bic;

    public BankAccountDTO(){
    }

    public BankAccountDTO(String bankName, String iban, String bic) {
        this.bankName = bankName;
        this.iban = iban;
        this.bic = bic;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getBic() {
        return bic;
    }

    public void setBic(String bic) {
        this.bic = bic;
    }
}
