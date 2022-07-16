package com.aslanmagamaev.crypto_exchange.web;

import com.aslanmagamaev.crypto_exchange.dto.AccountRegistrationDto;
import com.aslanmagamaev.crypto_exchange.service.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class AccountRegistrationController {

    private AccountService accountService;

    public AccountRegistrationController(AccountService accountService) {
        this.accountService = accountService;
    }

    public String registerAccount(@ModelAttribute("account")AccountRegistrationDto registrationDto) {
        accountService.save(registrationDto);
        return "redirect:/registration?success";
    }
}
