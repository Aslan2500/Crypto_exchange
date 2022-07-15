package com.aslanmagamaev.crypto_exchange.entity;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class AccountData implements Serializable {
    @NotEmpty(message = "{registration.validation.firstName}")
    private String name;
    @Email(message = "{registration.validation.email}")
    private String email;
    @NotEmpty()
    private int passport;
    @NotEmpty(message = "{registration.validation.password}")
    private String password;

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
