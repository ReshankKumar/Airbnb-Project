package com.jwt.Config;

//import com.jwt.JWTAuthenticationEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.intercept.AuthorizationFilter;

@Configuration
public class SecurityConfig {
    @Autowired
    private JWTRequestFilter jwtRequestFilter;
//   @Autowired
//    private JWTAuthenticationEntryPoint jwtAuthenticationEntryPoint;
//@Bean
//    public UserDetailsService getUserDetailsService(){
//
//        UserDetails userDetails = User.builder().username("prashank").password(getPasswordEncode().encode("123456abc")).roles("admin").build();
//        UserDetails userDetails1 = User.builder().username("Bipul").password(getPasswordEncode().encode("123456xyz")).roles("admin").build();
//        return new InMemoryUserDetailsManager(userDetails,userDetails1);
//    }
//    @Bean
//    public PasswordEncoder getPasswordEncode(){
//
//    return new BCryptPasswordEncoder();
//    }
    @Bean
   public SecurityFilterChain getFilterChain(HttpSecurity http)throws Exception{
        http.csrf().disable().cors().disable();
        http.addFilterBefore(jwtRequestFilter, AuthorizationFilter.class);
        http.authorizeHttpRequests().
                requestMatchers("/api/home/adduser","/api/home/verify").permitAll()
                .requestMatchers("/api/countries/addCountry").hasRole("ADMIN")
                .requestMatchers("/api/home/profile").hasAnyRole("ADMIN","USER")
                .anyRequest().authenticated();
        return http.build();
    }
    }

