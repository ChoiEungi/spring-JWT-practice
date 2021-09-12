package com.example.springjwtpractice;

import com.example.springjwtpractice.domain.Role;
import com.example.springjwtpractice.domain.User;
import com.example.springjwtpractice.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class SpringJwtPracticeApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringJwtPracticeApplication.class, args);
    }

    @Bean
    CommandLineRunner run(UserService userService){
        return  args -> {
            userService.saveUser(new User(null, "John Travolta", "john", "1234", Role.ROLE_ADMIN));
            userService.saveUser(new User(null, "Will Smith", "will", "1234", Role.ROLE_ADMIN));
            userService.saveUser(new User(null, "Jim Carry", "jim", "1234", Role.ROLE_USER));
            userService.saveUser(new User(null, "Arnold Schwarzenegger", "arnold", "1234", Role.ROLE_USER));
        };
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
