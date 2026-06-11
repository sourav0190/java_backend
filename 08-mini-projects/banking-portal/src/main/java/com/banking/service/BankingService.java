package com.banking.service;

import com.banking.model.Account;
import com.banking.model.Transaction;
import com.banking.model.User;
import com.banking.repository.AccountRepository;
import com.banking.repository.TransactionRepository;
import com.banking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class BankingService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void deposit(String username, BigDecimal amount) {
        Account account = accountRepository.findByUserUsername(username)
                .orElseThrow(() -> new RuntimeException("Account not found"));

        account.setBalance(account.getBalance().add(amount));
        accountRepository.save(account);

        Transaction transaction = new Transaction();
        transaction.setAmount(amount);
        transaction.setType("DEPOSIT");
        transaction.setTimestamp(LocalDateTime.now());
        transaction.setTargetAccount(account);
        transactionRepository.save(transaction);
    }

    @Transactional
    public void withdraw(String username, BigDecimal amount) {
        Account account = accountRepository.findByUserUsername(username)
                .orElseThrow(() -> new RuntimeException("Account not found"));

        if (account.getBalance().compareTo(amount) < 0) {
            throw new RuntimeException("Insufficient funds");
        }

        account.setBalance(account.getBalance().subtract(amount));
        accountRepository.save(account);

        Transaction transaction = new Transaction();
        transaction.setAmount(amount);
        transaction.setType("WITHDRAW");
        transaction.setTimestamp(LocalDateTime.now());
        transaction.setSourceAccount(account);
        transactionRepository.save(transaction);
    }

    @Transactional
    public void transfer(String fromUsername, String toUsername, BigDecimal amount) {
        if (fromUsername.equals(toUsername)) {
            throw new RuntimeException("Cannot transfer to self");
        }

        Account fromAccount = accountRepository.findByUserUsername(fromUsername)
                .orElseThrow(() -> new RuntimeException("Source account not found"));

        User toUser = userRepository.findByUsername(toUsername)
                .orElseThrow(() -> new RuntimeException("Target user not found"));
        Account toAccount = toUser.getAccount();

        if (fromAccount.getBalance().compareTo(amount) < 0) {
            throw new RuntimeException("Insufficient funds");
        }

        fromAccount.setBalance(fromAccount.getBalance().subtract(amount));
        toAccount.setBalance(toAccount.getBalance().add(amount));

        accountRepository.save(fromAccount);
        accountRepository.save(toAccount);

        Transaction transaction = new Transaction();
        transaction.setAmount(amount);
        transaction.setType("TRANSFER");
        transaction.setTimestamp(LocalDateTime.now());
        transaction.setSourceAccount(fromAccount);
        transaction.setTargetAccount(toAccount);
        transactionRepository.save(transaction);
    }

    public List<Transaction> getTransactionHistory(String username) {
        Account account = accountRepository.findByUserUsername(username)
                .orElseThrow(() -> new RuntimeException("Account not found"));
        return transactionRepository.findBySourceAccountIdOrTargetAccountIdOrderByTimestampDesc(account.getId(),
                account.getId());
    }

    public Account getAccount(String username) {
        return accountRepository.findByUserUsername(username).orElse(null);
    }
}
