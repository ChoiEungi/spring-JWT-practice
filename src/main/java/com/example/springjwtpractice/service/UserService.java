package com.example.springjwtpractice.service;

import com.example.springjwtpractice.domain.Role;
import com.example.springjwtpractice.domain.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    List<User> getUsers();
}
