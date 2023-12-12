package com.example.spring_security_demo.service;

import com.example.spring_security_demo.entity.User;
import com.example.spring_security_demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository repository;
    public User getById(String id){
        return repository.findById(id).orElseThrow();
    }
}
