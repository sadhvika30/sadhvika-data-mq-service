package com.sadhvika.activemqdemo;

import com.sadhvika.activemqdemo.repository.AccountRepository;
import com.sadhvika.activemqdemo.dto.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountDao {

    private final AccountRepository repository;

    @Autowired
    public AccountDao(AccountRepository repository) {
        this.repository = repository;
    }

    public List<Account> fetchAll() {
        return repository.findAll();
    }

    public Account fetchById(Long accountId) {
        return repository.findById(accountId).orElse(null);
    }

    public Account saveNew(Account accountData) {
        return repository.save(accountData);
    }

    public Account updateExisting(Long id, Account incomingData) {
        Account existing = fetchById(id);
        if (existing != null) {
            existing.setId(incomingData.getId());
            existing.setName(incomingData.getName());
            return repository.save(existing);
        }
        return null;
    }
}
