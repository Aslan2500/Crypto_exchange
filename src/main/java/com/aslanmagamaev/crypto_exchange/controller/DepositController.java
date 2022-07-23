package com.aslanmagamaev.crypto_exchange.controller;

import com.aslanmagamaev.crypto_exchange.dto.AccountDto;
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
@RequestMapping("/deposit")
public class DepositController {

    @Autowired
    private AccountService accountService;

    @ModelAttribute("account")
    public AccountDto accountDto() {
        return new AccountDto();
    }

    @GetMapping
    public String showDepositForm(Model model) {
        model.addAttribute("money", accountService.getCurrentAccount().getAmountOfMoney());
        model.addAttribute("bitcoin", accountService.getCurrentAccount().getAmountOfBitcoin());
        return "deposit";
    }

    @PostMapping
    public String depositAccount(@Valid @ModelAttribute AccountDto accountDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "deposit";
        }
        accountService.deposit(accountDto);
        return "redirect:/deposit?success";
    }
}
