package com.aslanmagamaev.crypto_exchange.controller;

import com.aslanmagamaev.crypto_exchange.dto.AccountDto;
import com.aslanmagamaev.crypto_exchange.entity.Account;
import com.aslanmagamaev.crypto_exchange.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/buy_bitcoin")
public class BuyBitcoinController {
    @Autowired
    private AccountService accountService;

    @ModelAttribute("account")
    public AccountDto accountDto() {
        return new AccountDto();
    }

    @ModelAttribute("currentBalance")
    public int currentBalance() {
        Account account = accountService.getCurrentAccount();
        return account.getAmountOfMoney();
    }

    @GetMapping
    public String buyBitcoinForm(Model model) {
        model.addAttribute("money", accountService.getCurrentAccount().getAmountOfMoney());
        model.addAttribute("bitcoin", accountService.getCurrentAccount().getAmountOfBitcoin());
        return "buy_bitcoin";
    }

    @PostMapping
    public String buyBitcoin(@Valid @ModelAttribute AccountDto accountDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "buy_bitcoin";
        }
        accountService.buyBitcoin(accountDto);
        return "redirect:/buy_bitcoin?success";
    }
}
