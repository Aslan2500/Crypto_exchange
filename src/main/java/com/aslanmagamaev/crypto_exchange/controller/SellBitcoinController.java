package com.aslanmagamaev.crypto_exchange.controller;

import com.aslanmagamaev.crypto_exchange.dto.AccountDto;
import com.aslanmagamaev.crypto_exchange.entity.Account;
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
@RequestMapping("/sell_bitcoin")
public class SellBitcoinController {
    @Autowired
    private AccountService accountService;

    @ModelAttribute("account")
    public AccountDto accountDto() {
        return new AccountDto();
    }

    @ModelAttribute("currentBitcoinBalance")
    public double currentBitcoinBalance() {
        Account account = accountService.getCurrentAccount();
        return account.getAmountOfBitcoin();
    }

    @GetMapping
    public String sellBitcoinForm() {
        return "sell_bitcoin";
    }

    @PostMapping
    public String buyBitcoin(@Valid @ModelAttribute("account") AccountDto accountDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "sell_bitcoin";
        }
        accountService.sellBitcoin(accountDto);
        return "redirect:/sell_bitcoin?success";
    }
}
