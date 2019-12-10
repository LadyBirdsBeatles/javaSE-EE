package com.cloud.beetles;

import com.cloud.cloudconfig.BeetlesRandomRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * 客服端
 */
@SpringBootApplication
@EnableEurekaClient //服务发现
@RibbonClient(name = "SPRINGCLOUD-PROVIDER-USER",configuration = BeetlesRandomRule.class)
public class UserConsumer8008 {
    public static void main(String[] args) {
        SpringApplication.run(UserConsumer8008.class, args);
    }
}
