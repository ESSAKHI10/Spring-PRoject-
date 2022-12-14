package com.example.demo.springsecuritynewfeatures.Repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.springsecuritynewfeatures.models.Employee;

@Repository
public class InMemoryEmployeerepository {
    private static List<Employee> DATABASE = new ArrayList<>();
    static {
        DATABASE.add(new Employee(1, "johne", "Smith", "john@gmail.com"));
        DATABASE.add(new Employee(2, "Alex", "Raymone", "alex@gmail.com"));
        DATABASE.add(new Employee(3, "david", "Cameron", "david@gmail.com"));
    }

    public Employee addEmployee(Employee emp) {
        DATABASE.add(emp);
        return emp;
    }

    public List<Employee> getAllEmployees() {
        return List.copyOf(DATABASE);
    }

    public Employee findbyId(Integer id) {
        return DATABASE
                .stream()
                .filter(emp -> id.equals(emp.getId()))
                .findFirst()
                .orElseThrow();

    }

    public void updateEmployee(Employee emp) {
    }

    public Boolean deleteById(Integer id) {
        Employee employee = DATABASE
                .stream()
                .filter(emp -> id.equals(emp.getId()))
                .findFirst()
                .orElseThrow();
        DATABASE.remove(employee);
        return Boolean.TRUE;
    }

}
