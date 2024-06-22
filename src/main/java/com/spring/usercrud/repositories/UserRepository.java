package com.spring.usercrud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.usercrud.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
}
