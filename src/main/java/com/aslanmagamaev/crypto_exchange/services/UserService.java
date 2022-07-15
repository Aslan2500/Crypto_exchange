package com.aslanmagamaev.crypto_exchange.services;

import com.aslanmagamaev.crypto_exchange.entity.Account;
import com.aslanmagamaev.crypto_exchange.entity.AccountData;
import com.aslanmagamaev.crypto_exchange.exceptions.UnknownIdentifierException;
import com.aslanmagamaev.crypto_exchange.exceptions.UserAlreadyExistException;

public interface UserService {

    void register(AccountData accountData) throws UserAlreadyExistException;

    boolean checkIfUserExist(final String email);
    Account getUserByEmail(final String email) throws UnknownIdentifierException;
}
