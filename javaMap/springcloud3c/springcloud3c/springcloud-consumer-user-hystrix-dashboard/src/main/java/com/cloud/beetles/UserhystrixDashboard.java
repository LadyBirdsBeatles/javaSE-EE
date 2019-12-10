package com.cloud.beetles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class UserhystrixDashboard {
    public static void main(String[] args) {
        SpringApplication.run(UserhystrixDashboard.class,args);
    }

}

