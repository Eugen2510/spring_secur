package com.example.spring_security_demo.service;

import com.example.spring_security_demo.entity.Employee;
import com.example.spring_security_demo.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class EmployeeService {
    private final EmployeeRepository repository;

    public Employee create(Employee user){
        return repository.save(user);
    }

    public List<Employee> getAllUsers(){
        return repository.findAll();
    }

    public Employee updateUser(Employee user){
        return repository.save(user);
    }

    public void deleteUser(int id){
        repository.deleteById(id);
    }

    public Employee getById(int id){
        return repository.findById(id).orElseThrow();
    }

    public List<Employee> getUsersByName(String name){
        return repository.findByNameContainsIgnoreCase(name);
    }
}
