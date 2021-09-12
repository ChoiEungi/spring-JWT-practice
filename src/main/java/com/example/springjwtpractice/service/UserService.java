package com.example.springjwtpractice.service;

import com.example.springjwtpractice.domain.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    User getUser(String username);
    List<User> getUsers();
}
