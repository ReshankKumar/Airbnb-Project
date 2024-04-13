package com.jwt.service;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JWTService {

        @Value("${jwt.algorithm.key}")
        private String algorithmKey;
        @Value("${jwt.issuer}")
        private String issuer;
        @Value("${jwt.expiry.duration}")
        private int expiryTime;
        private Algorithm algorithm;
        private final static String USER_NAME = "username";

        @PostConstruct
        public void postConstruct() {
            algorithm = Algorithm.HMAC256(algorithmKey);
        }

        public String generateToken(PropertyUser propertyUser) {
            return JWT.create().
                    withClaim(USER_NAME, propertyUser.getUsername())
                    .withExpiresAt(new Date(System.currentTimeMillis() + expiryTime))
                    .withIssuer(issuer)
                    .sign(algorithm);
        }
        //take the token and apply alogorithm and secret key to decript the token and check the issuer the verify the token
        //check the expiry time and return username from decode token
        public String getUsername(String token){
            DecodedJWT decodeJwt=JWT.require(algorithm).withIssuer(issuer).build().verify(token);
           return decodeJwt.getClaim(USER_NAME).asString();
        }
    }


