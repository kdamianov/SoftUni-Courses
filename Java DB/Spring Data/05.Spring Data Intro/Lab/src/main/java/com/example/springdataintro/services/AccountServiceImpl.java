package com.example.springdataintro.services;

import com.example.springdataintro.models.Account;
import com.example.springdataintro.repositories.AccountRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {
    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void withdrawMoney(BigDecimal money, Long id) {
        Optional<Account> accountOpt = accountRepository.findById(id); //returns Optional -> may be null

        if (accountOpt.isEmpty()) {
            throw new IllegalArgumentException("Account is missing!");
        }

        Account account = accountOpt.get(); //returns the Account
        BigDecimal newAmount = account.getBalance().subtract(money); //remove amount from balance

        if (newAmount.compareTo(BigDecimal.ZERO) < 0) { //BigDecimal uses Comparator!
            throw new IllegalArgumentException("Not enough balance!");
        }

        account.setBalance(newAmount); //set the new balance

        accountRepository.save(account); //save the result in DB
    }

    @Override
    public void transferMoney(BigDecimal money, Long id) {
        Account account = accountRepository
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Account is missing!"));

        if (money.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Cannot deposit negative amount!");
        }

        BigDecimal newAmount = account.getBalance().add(money); //add amount to balance

        account.setBalance(newAmount);
        accountRepository.save(account);
    }
}
