package com.example.demo.springsecuritynewfeatures.service.Imp;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.springsecuritynewfeatures.Entity.Account;
import com.example.demo.springsecuritynewfeatures.Entity.Role;
import com.example.demo.springsecuritynewfeatures.Repository.AccountRepository;
import com.example.demo.springsecuritynewfeatures.Repository.RoleRepository;
import com.example.demo.springsecuritynewfeatures.dto.AccountPrincipal;
import com.example.demo.springsecuritynewfeatures.mappers.AccountMapper;
import com.example.demo.springsecuritynewfeatures.service.IAccountService;

@Service
public class AccountServiceImpl implements IAccountService, UserDetailsService {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder encoder;

    @Override
    public Account createAccount(Account account) {
        // TODO Auto-generated method stub
        account.setPassword(encoder.encode(account.getPassword()));
        Role role = roleRepository.findByname("ROLE_USER");
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        account.setRoles(roles);
        return accountRepository.save(account);
    }

    @Override
    public List<Account> getAccounts() {
        // TODO Auto-generated method stub
        return accountRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account acc = accountRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User NOT Found"));
        return AccountMapper.accountToPrincipal(acc);
    }

}
