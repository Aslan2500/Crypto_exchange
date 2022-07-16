package com.aslanmagamaev.crypto_exchange.service;

import com.aslanmagamaev.crypto_exchange.dto.AccountRegistrationDto;
import com.aslanmagamaev.crypto_exchange.entity.Account;

public interface AccountService {
    Account save(AccountRegistrationDto registrationDto);
}
