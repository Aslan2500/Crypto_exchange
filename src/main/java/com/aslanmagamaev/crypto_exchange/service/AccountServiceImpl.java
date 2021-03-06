package com.aslanmagamaev.crypto_exchange.service;

import com.aslanmagamaev.crypto_exchange.dto.AccountDto;
import com.aslanmagamaev.crypto_exchange.entity.Account;
import com.aslanmagamaev.crypto_exchange.entity.Role;
import com.aslanmagamaev.crypto_exchange.parse.BitcoinPriceParse;
import com.aslanmagamaev.crypto_exchange.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account save(AccountDto accountDto) {
        Account account = new Account(accountDto.getName(),
                accountDto.getSurname(),
                accountDto.getEmail(),
                passwordEncoder.encode(accountDto.getPassword()), List.of(new Role("ROLE_USER")));
        return accountRepository.save(account);
    }

    @Override
    public Account deposit(AccountDto accountDto) {
        Account account = getCurrentAccount();
        account.setAmountOfMoney(account.getAmountOfMoney() + accountDto.getAmountOfMoney());
        return accountRepository.save(account);
    }

    @Override
    public Account withdraw(AccountDto accountDto) {
        Account account = getCurrentAccount();
        account.setAmountOfMoney(account.getAmountOfMoney() - accountDto.getAmountOfMoney());
        return accountRepository.save(account);
    }

    @Override
    public void buyBitcoin(AccountDto accountDto) {
        Account account = withdraw(accountDto);
        account.setAmountOfBitcoin(account.getAmountOfBitcoin() + (accountDto.getAmountOfMoney() / BitcoinPriceParse.getPrice()));
        accountRepository.save(account);
    }

    @Override
    public void sellBitcoin(AccountDto accountDto) {
        accountDto.setAmountOfMoney((int) (BitcoinPriceParse.getPrice() * accountDto.getAmountOfBitcoin()));
        Account account = deposit(accountDto);
        account.setAmountOfBitcoin(account.getAmountOfBitcoin() - accountDto.getAmountOfBitcoin());
        accountRepository.save(account);
    }

    @Override
    public Account getCurrentAccount() {
        return accountRepository.findByEmail((String) SecurityContextHolder.getContext().getAuthentication().getName());
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findByEmail(username);
        if(account == null) {
            throw new UsernameNotFoundException("Invalid username or password");
        }
        return new org.springframework.security.core.userdetails.User(account.getEmail(), account.getPassword(), mapRolesToAuthorities(account.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}
