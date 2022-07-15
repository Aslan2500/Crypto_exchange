package com.aslanmagamaev.crypto_exchange.services;

import com.aslanmagamaev.crypto_exchange.entity.Account;
import com.aslanmagamaev.crypto_exchange.exceptions.UnknownIdentifierException;
import com.aslanmagamaev.crypto_exchange.exceptions.UserAlreadyExistException;

public interface UserService {

    void register(final Account account) throws UserAlreadyExistException;
    boolean checkIfUserExist(final String email);
    Account getUserById(final String id) throws UnknownIdentifierException;
}
