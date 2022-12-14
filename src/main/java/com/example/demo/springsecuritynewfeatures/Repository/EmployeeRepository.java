package com.example.demo.springsecuritynewfeatures.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
 

import com.example.demo.springsecuritynewfeatures.models.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
//Define more if we need 
}
