package com.example.demo.springsecuritynewfeatures.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.springsecuritynewfeatures.Entity.Account;

public interface IAccountService {
    Account createAccount(Account account);

    UserDetails loadUserByUsername(String username);

    List<Account> getAccounts();
}
