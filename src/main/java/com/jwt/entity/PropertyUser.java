package com.jwt.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class PropertyUser {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String firstname;


    private String lastname;

    @Column(name = "user_name", nullable = false, unique = true, length = 150)
    private String username;
    @JsonIgnore
    @Column(name = "user_role", nullable = false, length = 20)
    private String userrole;
    @JsonIgnore
    @Column(name = "password", nullable = false, length = 200)
    private String password;

    @Column(name = "email", nullable = false, unique = true)
    private String email;
}
