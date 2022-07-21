package com.aslanmagamaev.crypto_exchange.dto;

import javax.validation.constraints.Email;

public class AccountDto {
    private String name;
    private String surname;
    @Email
    private String email;
    private String password;
    private int amountOfMoney;
    private double amountOfBitcoin;


    public AccountDto() {

    }

    public AccountDto(String name, String surname, String email, String password) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
    }

    public AccountDto(int amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAmountOfMoney() {
        return amountOfMoney;
    }

    public void setAmountOfMoney(int amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
    }

    public double getAmountOfBitcoin() {
        return amountOfBitcoin;
    }

    public void setAmountOfBitcoin(double amountOfBitcoin) {
        this.amountOfBitcoin = amountOfBitcoin;
    }
}
