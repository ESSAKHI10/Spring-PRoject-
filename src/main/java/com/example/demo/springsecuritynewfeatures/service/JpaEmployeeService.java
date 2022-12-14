package com.example.demo.springsecuritynewfeatures.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.springsecuritynewfeatures.Repository.EmployeeRepository;
import com.example.demo.springsecuritynewfeatures.models.Employee;

@Service
@Qualifier(value ="mySQLEmployeeService")
public class JpaEmployeeService implements IEmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee addEmployee(Employee emp) {

        employeeRepository.save(emp);
        return emp;
    }

    @Override
    public Boolean deleteById(Integer id) {
      
        employeeRepository.deleteById(id);
        return Boolean.TRUE;
    }

    @Override
    public Employee findById(Integer id) {
       
        return employeeRepository.findById(id).get( );
    }

    @Override
    public List<Employee> getAllEmployee() {
     
        return employeeRepository.findAll();
    }

    @Override
    public Employee updateEmployee(Employee employee) {
       return employeeRepository.save(employee);
        
    }

}
