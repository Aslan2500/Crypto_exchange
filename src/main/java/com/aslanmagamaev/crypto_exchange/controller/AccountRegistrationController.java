package com.aslanmagamaev.crypto_exchange.controller;

import com.aslanmagamaev.crypto_exchange.dto.AccountDto;
import com.aslanmagamaev.crypto_exchange.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class AccountRegistrationController {

    @Autowired
    private AccountService accountService;

    @ModelAttribute("account")
    public AccountDto accountDto() {
        return new AccountDto();
    }

    @GetMapping
    public String showRegistrationForm() {
        return "registration";
    }

    @PostMapping
    public String registerAccount(@ModelAttribute("account") AccountDto registrationDto) {
        accountService.save(registrationDto);
        return "redirect:/registration?success";
    }
}
