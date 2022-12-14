package com.example.demo.springsecuritynewfeatures.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.springsecuritynewfeatures.Repository.InMemoryEmployeerepository;
import com.example.demo.springsecuritynewfeatures.models.Employee;

@Service

public class InMemoryEmployeeServiceImp implements EmployeeService {

    @Autowired
    private InMemoryEmployeerepository inMemoryEmployeerepository;

    @Override
    public void addEmployee(Employee emp) {
        // TODO Auto-generated method stub
        inMemoryEmployeerepository.addEmployee(emp);

    }

    @Override
    public List<Employee> getAllEmployee() {
        // TODO Auto-generated method stub
        return inMemoryEmployeerepository.getAllEmployees();
    }

    @Override
    public Employee findById(Integer id) {
        // TODO Auto-generated method stub
        return inMemoryEmployeerepository.findbyId(id);
    }

    @Override
    public void updateEmployee(Employee employee) {
        // TODO Auto-generated method stub

    }

    @Override
    public Boolean deleteById(Integer id) {
        // TODO Auto-generated method stub
        return inMemoryEmployeerepository.deleteById(id);
    }

}
