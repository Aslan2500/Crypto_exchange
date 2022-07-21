package com.aslanmagamaev.crypto_exchange.controller;

import com.aslanmagamaev.crypto_exchange.dto.AccountDto;
import com.aslanmagamaev.crypto_exchange.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/withdraw")
public class WithdrawController {
    @Autowired
    private AccountService accountService;

    @ModelAttribute("account")
    public AccountDto accountDto() {
        return new AccountDto();
    }

    @GetMapping
    public String showWithdrawtForm() {
        return "withdraw";
    }

    @PostMapping
    public String withdrawAccount(@Valid @ModelAttribute("account") AccountDto accountDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "withdraw";
        }
        accountService.withdraw(accountDto);
        return "redirect:/withdraw?success";
    }
}
