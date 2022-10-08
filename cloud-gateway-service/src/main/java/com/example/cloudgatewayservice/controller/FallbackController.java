package com.example.cloudgatewayservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fallback")
public class FallbackController {
    @GetMapping("/questions")
    public ResponseEntity<String> getQuestions(){
        return new ResponseEntity<String>("Request Time Out", HttpStatus.OK);
    }
}
