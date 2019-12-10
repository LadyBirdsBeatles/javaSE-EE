package com.cloud.beetles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServices_8088 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServices_8088.class,args);
    }
}
