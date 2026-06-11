package com.securityTutorial.security.repo;

import com.securityTutorial.security.entity.EmployeeSignup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeSignupRepo extends JpaRepository<EmployeeSignup, Integer> {
    EmployeeSignup findByUserName(String username);
}
