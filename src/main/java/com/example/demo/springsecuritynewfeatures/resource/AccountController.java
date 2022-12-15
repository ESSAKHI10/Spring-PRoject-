package com.example.demo.springsecuritynewfeatures.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.springsecuritynewfeatures.Entity.Account;
import com.example.demo.springsecuritynewfeatures.service.IAccountService;

@RestController
@RequestMapping(path = "/api/accounts")
public class AccountController{
    @Autowired
    private   IAccountService accountService;

    @PostMapping
    public ResponseEntity<Account> createAccount (@RequestBody Account account) {
        Account newAccount = accountService.createAccount(account);
        return ResponseEntity.ok(newAccount);
    }

    @GetMapping
    public ResponseEntity<List<Account>>getAccount() {
        return ResponseEntity.ok(accountService.getAccounts());
    }
}