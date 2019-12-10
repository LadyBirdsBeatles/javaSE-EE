package com.cloud.beetles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * 客服端
 * @author xiaochen
 */
@SpringBootApplication
@EnableEurekaClient //服务发现
@EnableFeignClients(basePackages = "com.cloud.beetles")
@ComponentScan("com.cloud.beetles")
public class UserConsumerFeign8008 {
    public static void main(String[] args) {
        SpringApplication.run(UserConsumerFeign8008.class, args);
    }
}
