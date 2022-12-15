package com.example.demo.springsecuritynewfeatures.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.example.demo.springsecuritynewfeatures.Entity.Account;
import com.example.demo.springsecuritynewfeatures.dto.AccountPrincipal;

public class AccountMapper {
    public static AccountPrincipal accountToPrincipal(Account acc) {
        AccountPrincipal accp = new AccountPrincipal();
        List<SimpleGrantedAuthority> authorities = acc.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getName())).collect(Collectors.toList());

        accp.setUsername(acc.getUsername());
        accp.setPassword(acc.getPassword());
        accp.setEnabled(acc.isEnabled());
        accp.setAuthorities(authorities);
        return accp;
    }
}