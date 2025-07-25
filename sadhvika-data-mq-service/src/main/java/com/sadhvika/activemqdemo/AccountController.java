package com.sadhvika.activemqdemo.controller;

import com.sadhvika.activemqdemo.Account;
import com.sadhvika.activemqdemo.ResponseStructure;
import com.sadhvika.activemqdemo.service.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    private final AccountService service;

    @Autowired
    public AccountController(AccountService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseStructure<Account> registerNewAccount(@RequestBody Account payload) {
        return service.createAccount(payload);
    }

    @GetMapping
    public ResponseStructure<List<Account>> fetchAllAccounts() {
        return service.getAllAccounts();
    }

    @GetMapping("/{id}")
    public ResponseStructure<Account> fetchAccountById(@PathVariable("id") Long accountId) {
        return service.getAccountById(accountId);
    }

    @PutMapping("/{id}")
    public ResponseStructure<Account> modifyAccount(@PathVariable("id") Long accountId,
                                                    @RequestBody Account updatedData) {
        return service.updateAccount(updatedData, accountId);
    }
}
