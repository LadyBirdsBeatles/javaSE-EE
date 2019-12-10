package com.cloud.beetles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author xiaochen
 */ //启动类
@SpringBootApplication
@EnableEurekaClient //服务启动注册到eureka中
@EnableDiscoveryClient //服务发现
public class UserProvider8003 {
    public static void main(String[] args) {
        SpringApplication.run(UserProvider8003.class, args);
    }
}
