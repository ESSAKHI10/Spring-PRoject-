package com.example.demo.springsecuritynewfeatures.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.springsecuritynewfeatures.Entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByname(String name);

}
