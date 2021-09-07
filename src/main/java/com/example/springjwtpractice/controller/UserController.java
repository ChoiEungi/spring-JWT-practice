package com.example.springjwtpractice.controller;


import com.example.springjwtpractice.controller.dto.RoleToUserDto;
import com.example.springjwtpractice.domain.Role;
import com.example.springjwtpractice.domain.User;
import com.example.springjwtpractice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUser(){
        return ResponseEntity.ok().body(userService.getUsers());
    }

    @PostMapping("/users")
    public ResponseEntity<User> saveUser(@RequestBody User user){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/save").toUriString()); // return uri on header
        return ResponseEntity.created(uri).body(userService.saveUser(user));
    }

    @PostMapping("/role/users")
    public ResponseEntity<Role> saveRole(@RequestBody Role role){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/save").toUriString()); // return uri on header
        return ResponseEntity.created(uri).body(userService.saveRole(role));
    }

    @PostMapping("/role/addtouser")
    public ResponseEntity<?> addRoleToUser(@RequestBody RoleToUserDto form){
        userService.addRoleToUser(form.getUsername(), form.getUsername());
        return ResponseEntity.ok().build();
    }



}
