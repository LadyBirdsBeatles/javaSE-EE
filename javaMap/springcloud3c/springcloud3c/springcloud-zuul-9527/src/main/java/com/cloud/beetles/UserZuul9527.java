package com.cloud.beetles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class UserZuul9527 {
    public static void main(String[] args) {
        SpringApplication.run(UserZuul9527.class,args);
    }

}

