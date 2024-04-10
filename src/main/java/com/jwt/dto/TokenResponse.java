package com.jwt.dto;

import lombok.Data;

@Data
public class TokenResponse {
    private String type="Bearer";
    private String token;


}
