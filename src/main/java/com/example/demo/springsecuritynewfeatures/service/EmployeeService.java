package com.example.demo.springsecuritynewfeatures.service;

import java.util.List;

import com.example.demo.springsecuritynewfeatures.models.Employee;

public interface EmployeeService {
    // save an emp
    void addEmployee(Employee emp);

    // get all employees
    List<Employee> getAllEmployee();

    // get one Employee
    Employee findById(Integer id);

    // Update emplyee
    void updateEmployee(Employee employee);

    // delete an emplyee
    Boolean deleteById(Integer id);

}
