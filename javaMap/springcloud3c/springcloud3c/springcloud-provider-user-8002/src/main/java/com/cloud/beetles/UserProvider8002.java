package com.cloud.beetles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 启动类
 *
 * @author xiaochen
 */
@SpringBootApplication
@EnableEurekaClient //服务启动后注册到eureka中
@EnableDiscoveryClient //服务发现
public class UserProvider8002 {
    public static void main(String[] args) {
        SpringApplication.run(UserProvider8002.class, args);
    }
}
