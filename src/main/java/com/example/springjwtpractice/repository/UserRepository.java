package com.example.springjwtpractice.repository;

import com.example.springjwtpractice.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{
    User findByUsername(String username); // jpa interpret as select query
}
