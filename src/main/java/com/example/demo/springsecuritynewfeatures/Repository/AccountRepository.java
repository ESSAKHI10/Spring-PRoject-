package com.example.demo.springsecuritynewfeatures.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.springsecuritynewfeatures.Entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
    // Account findByUsername(String username);
    Optional<Account> findByUsername(String username);

}
