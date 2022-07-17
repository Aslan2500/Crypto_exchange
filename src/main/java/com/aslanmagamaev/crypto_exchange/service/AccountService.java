package com.aslanmagamaev.crypto_exchange.service;

import com.aslanmagamaev.crypto_exchange.dto.AccountRegistrationDto;
import com.aslanmagamaev.crypto_exchange.entity.Account;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AccountService extends UserDetailsService {
    Account save(AccountRegistrationDto registrationDto);
}
