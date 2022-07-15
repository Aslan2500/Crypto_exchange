package com.aslanmagamaev.crypto_exchange.entity;

import javax.persistence.*;

@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "passport", unique = true)
    private int passport;
    @Column(name = "password")
    private String password;
    @Column(name = "amount_of_money")
    private int amountOfMoney;
    @Column(name = "amount_of_bitcoin")
    private double amountOfBitcoin;

    public Account() {
    }

    public Account(String name, String email, int passport, String password) {
        this.name = name;
        this.email = email;
        this.passport = passport;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPassport() {
        return passport;
    }

    public void setPassport(int passport) {
        this.passport = passport;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
