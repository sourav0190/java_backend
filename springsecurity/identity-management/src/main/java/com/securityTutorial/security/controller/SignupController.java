package com.securityTutorial.security.controller;

import com.securityTutorial.security.entity.EmployeeSignup;
import com.securityTutorial.security.repo.SignupRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignupController {

    @Autowired
    private SignupRepo signupRepo;

    @PostMapping("/signup")
    public String signup(@RequestBody EmployeeSignup employeeSignup) {
        signupRepo.save(employeeSignup);
        return "signup successfully";
    }
}
