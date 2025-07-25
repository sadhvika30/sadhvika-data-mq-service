package com.sadhvika.activemqdemo.Service;

import com.sadhvika.activemqdemo.Dao.AccountDao;
import com.sadhvika.activemqdemo.Dto.Account;
import com.sadhvika.activemqdemo.Dto.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    private final AccountDao dao;

    @Autowired
    public AccountService(AccountDao dao) {
        this.dao = dao;
    }

    public ResponseStructure<Account> registerAccount(Account input) {
        ResponseStructure<Account> response = new ResponseStructure<>();
        Account saved = dao.createAccount(input);

        if (saved != null) {
            response.setData(saved);
            response.setStatusCode(HttpStatus.CREATED.value());
            response.setMessage("New account created successfully.");
        } else {
            response.setStatusCode(HttpStatus.BAD_REQUEST.value());
            response.setMessage("Account creation failed.");
        }
        return response;
    }

    public ResponseStructure<List<Account>> retrieveAllAccounts() {
        ResponseStructure<List<Account>> response = new ResponseStructure<>();
        List<Account> result = dao.getAllAccounts();

        response.setData(result);
        response.setStatusCode(HttpStatus.OK.value());
        response.setMessage(result != null && !result.isEmpty() ?
                "Fetched all accounts successfully." :
                "No account records found.");
        return response;
    }

    public ResponseStructure<Account> retrieveAccountById(Long id) {
        ResponseStructure<Account> response = new ResponseStructure<>();
        Account account = dao.getAccountById(id);

        if (account != null) {
            response.setData(account);
            response.setStatusCode(HttpStatus.OK.value());
            response.setMessage("Account found for ID: " + id);
        } else {
            response.setStatusCode(HttpStatus.NOT_FOUND.value());
            response.setMessage("No account found with ID: " + id);
        }
        return response;
    }

    public ResponseStructure<Account> modifyAccount(Long id, Account update) {
        ResponseStructure<Account> response = new ResponseStructure<>();
        Account existing = dao.getAccountById(id);
        Account updated = dao.updateAccount(update, id);

        if (existing != null && updated != null) {
            response.setData(updated);
            response.setStatusCode(HttpStatus.OK.value());
            response.setMessage("Account with ID: " + id + " updated successfully.");
        } else {
            response.setStatusCode(HttpStatus.NOT_FOUND.value());
            response.setMessage("Account update failed. ID not found.");
        }
        return response;
    }
}
