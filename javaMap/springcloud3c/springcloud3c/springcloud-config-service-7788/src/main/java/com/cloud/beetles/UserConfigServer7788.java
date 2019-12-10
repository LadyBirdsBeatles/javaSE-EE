package com.cloud.beetles;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * 客服端
 */
@SpringBootApplication
@EnableConfigServer
public class UserConfigServer7788 {
    public static void main(String[] args) {
        SpringApplication.run(UserConfigServer7788.class, args);
    }
}
