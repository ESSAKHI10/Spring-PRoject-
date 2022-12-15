package com.example.demo.springsecuritynewfeatures.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.springsecuritynewfeatures.Entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
//Define more if we need 
}
