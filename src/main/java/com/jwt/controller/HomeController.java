package com.jwt.controller;

import com.jwt.dto.TokenResponse;
import com.jwt.service.UserService;
import com.jwt.dto.LoginDto;
import com.jwt.dto.PropertyUserDto;
import com.jwt.entity.PropertyUser;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/home")
@AllArgsConstructor
public class HomeController {
    private UserService service;

    //http://localhost:8080/home/user
//   @GetMapping("/user")
////    public String getUser(){
////       System.out.println("getting users");
////       return "user";
////    }
//   public List<User> getUser(){
//       System.out.println("getting users");
//       return service.getUser();
//   }
//   @GetMapping("/current-user")
//public String getLoggedInUser(Principal principal){
//return principal.getName();
    //http:localhost:8080/api/home/adduser
    @PostMapping("/adduser")
    public ResponseEntity<String> addUserData(@RequestBody PropertyUserDto dto){
        PropertyUser propertyUser = service.addUser(dto);
        if(propertyUser!=null) {
            return new ResponseEntity<>("data is added", HttpStatus.CREATED);
        }
        else{
            return new ResponseEntity<>("Something went wrong", HttpStatus.CREATED);
        }

    }
    @PostMapping("/verify")
    public ResponseEntity<?> verifyLogin(@RequestBody LoginDto logindto){
        String token=service.verifyLogin(logindto);
        if(token!=null){
            TokenResponse response=new TokenResponse();
            response.setToken(token);
            return new ResponseEntity<>(response,HttpStatus.OK);
        }
        return new ResponseEntity<>("Invalid credentials",HttpStatus.BAD_REQUEST);
    }
    @GetMapping("/profile")
    public PropertyUser getCurrentUserProfile(@AuthenticationPrincipal PropertyUser propertyUser){
        return propertyUser;
    }
}



