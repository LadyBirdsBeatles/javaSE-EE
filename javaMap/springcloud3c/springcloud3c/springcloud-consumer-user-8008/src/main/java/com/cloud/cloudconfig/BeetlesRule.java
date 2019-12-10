package com.cloud.cloudconfig;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeetlesRule {
    /*
     *随机
     */
    @Bean
    public IRule myiRule() {
        //官方的
        /*return new RandomRule();*/
        //自定义的
        return new BeetlesRandomRule();
    }
}
