package com.cloud.beetles;

import com.netflix.hystrix.contrib.sample.stream.HystrixConfigSseServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.RegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

/**
 * 启动类
 *
 * @author xiaochen
 */
@SpringBootApplication
@EnableEurekaClient //服务启动后注册到eureka中
@EnableDiscoveryClient//服务发现
@EnableCircuitBreaker
public class UserProviderHystrix8001 {
    public static void main(String[] args) {
        SpringApplication.run(UserProviderHystrix8001.class, args);

    }

    @Bean
    public ServletRegistrationBean hystrixConfigSseServlet() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new HystrixConfigSseServlet());
      servletRegistrationBean.addUrlMappings("/actuator/hystrix.system");
      return servletRegistrationBean;
    }
}

