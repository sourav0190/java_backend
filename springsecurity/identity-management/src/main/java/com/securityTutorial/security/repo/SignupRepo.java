package com.securityTutorial.security.repo;

import com.securityTutorial.security.entity.EmployeeSignup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SignupRepo extends JpaRepository<EmployeeSignup, Integer> {
}
