package com.aslanmagamaev.crypto_exchange.repositories;

import com.aslanmagamaev.crypto_exchange.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
    Account findByEmail(String email);
}
