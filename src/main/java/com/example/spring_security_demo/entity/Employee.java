package com.example.spring_security_demo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "employee")
@Data
public class Employee {
    public Employee(String name){
        this.name = name;
    }

    public Employee(){

    }

    @Id()
    @Column(name = "employee_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "employee_name")
    private String name;

    @Column(name = "salary")
    private int salary;
}
