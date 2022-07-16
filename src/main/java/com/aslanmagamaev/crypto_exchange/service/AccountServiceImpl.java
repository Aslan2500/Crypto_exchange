package com.aslanmagamaev.crypto_exchange.service;

import com.aslanmagamaev.crypto_exchange.dto.AccountRegistrationDto;
import com.aslanmagamaev.crypto_exchange.entity.Account;
import com.aslanmagamaev.crypto_exchange.entity.Role;
import com.aslanmagamaev.crypto_exchange.repositories.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account save(AccountRegistrationDto registrationDto) {
        Account account = new Account(registrationDto.getName(),
                registrationDto.getSurname(),
                registrationDto.getEmail(),
                registrationDto.getPassword(), Arrays.asList(new Role("ROLE_USER")));
        return accountRepository.save(account);
    }
}
