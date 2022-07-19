package com.aslanmagamaev.crypto_exchange.controller;

import com.aslanmagamaev.crypto_exchange.dto.AccountDto;
import com.aslanmagamaev.crypto_exchange.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/deposit")
public class DepositController {

    @Autowired
    private AccountService accountService;

    @ModelAttribute("account")
    public AccountDto accountDto() {
        return new AccountDto();
    }

    @GetMapping
    public String showDepositForm() {
        return "deposit";
    }

    @PostMapping
    public String depositAccount(@ModelAttribute("account") AccountDto accountDto) {
        accountService.deposit(accountDto);
        return "redirect:/index";
    }
}
