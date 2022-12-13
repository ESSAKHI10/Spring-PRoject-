package com.example.demo.springsecuritynewfeatures.Repository;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class UserDao {

        private final static List<UserDetails> APPLICSTION_USERS = Arrays.asList(
                        new User(
                                        "Essakhihamzae@gmail.com",
                                        "password",
                                        Collections.singleton(new SimpleGrantedAuthority("ROLE_ADMINE"))),
                        new User(
                                        "user@gmail.com",
                                        "password",
                                        Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"))));

        public UserDetails findUserByEmail(String email) {
                return APPLICSTION_USERS
                                .stream()
                                .filter(u -> u.getUsername().equals(email))
                                .findFirst()
                                .orElseThrow(() -> new UsernameNotFoundException("no user was found"));

        }
}
