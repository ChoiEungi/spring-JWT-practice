package com.example.springjwtpractice.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String username; //email or something
    private String password;
    @ManyToMany(fetch = FetchType.EAGER) //want to load all of role whenever load the user
    private Collection<Role> roles = new ArrayList<>();

}
