package com.example.demo.springsecuritynewfeatures.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.springsecuritynewfeatures.Entity.Role;
import com.example.demo.springsecuritynewfeatures.Repository.RoleRepository;

import static java.util.Arrays.asList;
@Component

public class ApplicationStartRunner implements CommandLineRunner {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {
        Role roleUser = new Role(1L, "123", "ROLE_USER");
        Role roleAdmin = new Role(2L, "456", "ROLE_ADMIN");
        roleRepository.saveAll(asList(roleUser, roleAdmin));
    }
}
