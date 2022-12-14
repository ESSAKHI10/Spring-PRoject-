package com.example.demo.springsecuritynewfeatures.service;

import java.util.List;

import com.example.demo.springsecuritynewfeatures.models.Employee;

public interface IEmployeeService {
    // save an emp
    Employee addEmployee(Employee emp);

    // get all employees
    List<Employee> getAllEmployee();

    // get one Employee
    Employee findById(Integer id);

    // Update emplyee
    Employee updateEmployee(Employee employee);

    // delete an emplyee
    Boolean deleteById(Integer id);

}
