package com.example.spring_security_demo.controller;

import com.example.spring_security_demo.entity.Employee;
import com.example.spring_security_demo.security.PrincipalService;
import com.example.spring_security_demo.service.EmployeeService;
import jakarta.annotation.security.RolesAllowed;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
@RequestMapping("/user")
public class EmployeeController {
    private final EmployeeService service;
//    private final PrincipalService principalService;
//    private final UserDetailsService userDetailsService;

    @GetMapping("/show")
    public String show(Model model){
//        System.out.println("SecurityContextHolder.getContextHolderStrategy().getClass() = " + SecurityContextHolder.getContextHolderStrategy().getClass());
//        SecurityContext context = SecurityContextHolder.getContext();
//        Authentication authentication = context.getAuthentication();
//        String username = authentication.getName();
//        Object principal = authentication.getPrincipal();
//        System.out.println("username = " + username);
//        System.out.println("principal = " + principal);
//        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
//        for (GrantedAuthority authority : authorities) {
//            System.out.println("authority.getAuthority() = " + authority.getAuthority());
//        }
//

//        System.out.println("principalService.getUsername() = " + principalService.getUsername());
//        System.out.println("principalService.getRoles() = " + principalService.getRoles());
//        System.out.println("principalService.hasRole(\"USER\") = " + principalService.hasRole("ROLE_USER"));
//        System.out.println("userDetailsService.getClass() = " + userDetailsService.getClass());

        model.addAttribute("users", service.getAllUsers());
        return "show_users";
    }

    @GetMapping("/create")
    public String showCreatePage(@RequestParam(name = "name", required = false) String name){

        if (name != null){
            service.create(new Employee(name));
            System.out.println(name);
        }
        return "create_user";
    }

    @GetMapping("/show-by-name")
    public String getAllUsersByName(Model model, @RequestParam (name = "name", required = false) String name){
        model.addAttribute("users", service.getUsersByName(name));
        return "show_by_name";
    }

    @RolesAllowed(value = {"ADMIN"})
    //do not work((
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/create")
    public String createUser(@RequestParam(name = "name", required = false) String name){
        System.out.println(name);
        service.create(new Employee(name));
        return "redirect:/user/show";
    }
}
