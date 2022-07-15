package com.aslanmagamaev.crypto_exchange.services;

import com.aslanmagamaev.crypto_exchange.entity.Account;
import com.aslanmagamaev.crypto_exchange.entity.AccountData;
import com.aslanmagamaev.crypto_exchange.exceptions.UnknownIdentifierException;
import com.aslanmagamaev.crypto_exchange.exceptions.UserAlreadyExistException;
import com.aslanmagamaev.crypto_exchange.repositories.AccountRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

public class DefaultUserService implements UserService {
    @Autowired
    AccountRepository accountRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void register(AccountData accountData) throws UserAlreadyExistException {
        //Let's check if user already registered with us
        if(checkIfUserExist(accountData.getEmail())){
            throw new UserAlreadyExistException("User already exists for this email");
        }
        Account account = new Account();
        BeanUtils.copyProperties(accountData, account);
        encodePassword(account, accountData);
        accountRepository.save(account);
    }

    @Override
    public boolean checkIfUserExist(String email) {
        return accountRepository.findByEmail(email) != null;
    }

    @Override
    public Account getUserByEmail(String email) throws UnknownIdentifierException {
        return accountRepository.findByEmail(email);
    }

    private void encodePassword(Account account, AccountData accountData){
        account.setPassword(passwordEncoder.encode(accountData.getPassword()));
    }
}
