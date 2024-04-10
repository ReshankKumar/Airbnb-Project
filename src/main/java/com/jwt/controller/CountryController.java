package com.jwt.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



    @RestController
    @RequestMapping("/api/countries")
    public class CountryController {
        //http://localhost:8080/api/countries/addCountry
        @PostMapping("/addCountry")
        public String addCountry() {
            return "done";
        }
    }


