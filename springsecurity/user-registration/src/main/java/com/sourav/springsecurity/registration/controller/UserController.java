package com.sourav.springsecurity.registration.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.web.csrf.CsrfToken;
import com.sourav.springsecurity.registration.model.Employee;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @GetMapping("/home")
    public String getdata() {
        return "Hello World";
    }

    @GetMapping("/csrf")
    public String csrf(CsrfToken token) {
        return token.getToken();
    }

    private List<Employee> list = new ArrayList<>();

    {
        list.add(new Employee("sourav", 101, 22));
    }

    @GetMapping("/emp")
    public List<Employee> getEmployees() {
        return list;
    }

    @PostMapping("/add")
    public void addEmployee(@RequestBody Employee employee) {
        list.add(employee);
    }

}
