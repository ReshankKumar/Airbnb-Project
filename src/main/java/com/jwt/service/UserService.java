package com.jwt.service;

import com.jwt.dto.LoginDto;
import com.jwt.dto.PropertyUserDto;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
    private PropertUserRepository repository;
    private JWTService jwtService;
    public PropertyUser addUser(PropertyUserDto propertyUserDto) {
        PropertyUser user=new PropertyUser();
        user.setFirstname(propertyUserDto.getFirstname());
       user.setLastname(propertyUserDto.getLastname());
       user.setUsername(propertyUserDto.getUsername());
       user.setUserrole(propertyUserDto.getUserrole());
       user.setPassword(BCrypt.hashpw(propertyUserDto.getPassword(),BCrypt.gensalt(10)));
       user.setEmail(propertyUserDto.getEmail());
        PropertyUser save = repository.save(user);
        return save;
    }

    public String verifyLogin(LoginDto logindto) {
        Optional<PropertyUser> byUsername = repository.findByUsername(logindto.getUsername());
        if(byUsername.isPresent()){
            PropertyUser propertyUser = byUsername.get();
           if(BCrypt.checkpw(logindto.getPassword(),propertyUser.getPassword())){
               return jwtService.generateToken(propertyUser);
           }
        }
        return null;
    }
//    private List<User> store=new ArrayList<>();
//
//    public UserService(){
//        store.add(new User(UUID.randomUUID().toString(),"reshank","tiwari@gmail.com"));
//        store.add(new User(UUID.randomUUID().toString(),"prashank","tiwari121@gmail.com"));
//        store.add(new User(UUID.randomUUID().toString(),"sheshank","tiwari122@gmail.com"));
//    }
//    public List<User> getUser(){
//        return store;
//    }

}
