package com.aslanmagamaev.crypto_exchange.service;

import com.aslanmagamaev.crypto_exchange.dto.AccountDto;
import com.aslanmagamaev.crypto_exchange.entity.Account;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AccountService extends UserDetailsService {
    Account save(AccountDto accountDto);
    Account deposit(AccountDto accountDto);
    Account withdraw(AccountDto accountDto);
    void buyBitcoin(AccountDto accountDto);
    public Account getCurrentAccount();
}
