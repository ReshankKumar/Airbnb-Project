package com.jwt.dto;

import lombok.Data;

@Data
public class PropertyUserDto {

    private Long id;
    private String firstname;
    private String lastname;
    private String username;
    private String userrole;
    private String password;
    private String email;
}
