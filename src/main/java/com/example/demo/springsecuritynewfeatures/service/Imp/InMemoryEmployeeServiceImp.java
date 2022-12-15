package com.example.demo.springsecuritynewfeatures.service.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.springsecuritynewfeatures.Entity.Employee;
import com.example.demo.springsecuritynewfeatures.Repository.InMemoryEmployeerepository;
import com.example.demo.springsecuritynewfeatures.service.IEmployeeService;

@Service
@Qualifier(value ="inMemoryEmployeeService")
public class InMemoryEmployeeServiceImp implements IEmployeeService {

    @Autowired
  
    private InMemoryEmployeerepository inMemoryEmployeerepository;

    @Override
    public Employee addEmployee(Employee emp) {
        // TODO Auto-generated method stub
       return  inMemoryEmployeerepository.addEmployee(emp);

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
    public Employee updateEmployee(Employee employee) {
        // TODO Auto-generated method stub
        return employee;

    }

    @Override
    public Boolean deleteById(Integer id) {
        // TODO Auto-generated method stub
        return inMemoryEmployeerepository.deleteById(id);
    }

}
