package com.example.spring_security_demo.repository;

import com.example.spring_security_demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    public List<Employee> findByNameContainsIgnoreCase(String name);
}
