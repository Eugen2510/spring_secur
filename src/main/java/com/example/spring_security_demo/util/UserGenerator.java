package com.example.spring_security_demo.util;

//import com.example.spring_security_demo.entity.User;
//import com.example.spring_security_demo.service.UserService;
//import jakarta.annotation.PostConstruct;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//import java.util.stream.Collectors;
//import java.util.stream.IntStream;
//
//@Component
//public class UserGenerator {
//    private UserService service;
//
//    @PostConstruct
//    @Autowired
//    private void init(UserService service){
//        this.service = service;
//    }
//    public  void generate(int count){
//         IntStream.range(0, count)
//                 .forEach(i -> service.create(new User("Name" + i)));
////                .mapToObj(i -> new User("name" + i))
////                .collect(Collectors.toList());
//
//    }
//
//    public void showAll(){
//        List<User> users = service.getAllUsers();
//        users
//                .forEach(System.out::println);
//    }
//
//}
