package com.example.lookupservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class LookupServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(LookupServiceApplication.class, args);
    }

}
