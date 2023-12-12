package com.example.spring_security_demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @Column(name = "username")
    private String name;

    @Column (name = "password")
    private String password;

    @Column(name = "enabled")
    private boolean enabled;
}
