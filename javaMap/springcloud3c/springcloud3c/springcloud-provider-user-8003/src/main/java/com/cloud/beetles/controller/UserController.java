package com.cloud.beetles.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cloud.beetles.servise.UserServise;
import com.cloud.beetles.pojo.Users;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Slf4j
@Controller
@ResponseBody
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServise userServise;
    @Autowired
    private DiscoveryClient discoveryClient;

    @ResponseBody
    @RequestMapping(value = "/adduser", produces = {"application/json;charset=UTF-8"})
    public boolean adduser(@RequestParam String data) {
        log.info(data);
        return userServise.adduser(data);
    }

    @ResponseBody
    @RequestMapping(value = "/queryuid", produces = {"application/json;charset=UTF-8"})
    public Users queryuid(long id) {
        System.out.println(id);
        return userServise.queryuserid(id);
    }

    @ResponseBody
    @RequestMapping(value = "/queryuser", produces = {"application/json;charset=UTF-8"})
    public List queryuser() {
        for (Object o : userServise.queryuser()) {
            System.out.println((Users) o);
        }
        return userServise.queryuser();
    }

    @RequestMapping("/dec")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        System.out.println(services);
        List<ServiceInstance> instances = discoveryClient.getInstances("SPRINGCLOUD-PROVIDER-USER");
        for (ServiceInstance instance : instances) {
            System.out.println(instance.getHost() +
                    instance.getPort() +
                    instance.getUri() +
                    instance.getServiceId());
        }
        return this.discoveryClient;
    }
}
