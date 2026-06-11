package com.sourav.springsecurity.registration.repository;

import com.sourav.springsecurity.registration.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SignupRepository extends JpaRepository<UserEntity, Integer> {
}
