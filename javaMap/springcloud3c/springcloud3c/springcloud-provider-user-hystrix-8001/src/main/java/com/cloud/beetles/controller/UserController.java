package com.cloud.beetles.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cloud.beetles.service.UserClientService;
import com.cloud.beetles.servise.UserServise;
import com.cloud.beetles.pojo.Users;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserClientService userServise;
    @Autowired
    private DiscoveryClient discoveryClient;

    @ResponseBody
    @RequestMapping(value = "/adduser", produces = {"application/json;charset=UTF-8"})
    public boolean adduser(Users user) {
        return this.userServise.adduser(user);
    }

    @ResponseBody
    @RequestMapping(value = "/queryuid", produces = {"application/json;charset=UTF-8"})
    @HystrixCommand(fallbackMethod = "hystrixget")
    public Users queryuid(@PathVariable("id") long id) {
        Users queryuser = this.userServise.queryuser(id);
        if (queryuser == null) {
            throw new RuntimeException("不存在" + id + "用户");
        } else {
            return queryuser;
        }
    }

    /**
     * 备选方案
     *
     * @param id
     * @return
     */
    public Users hystrixget(@PathVariable("id") long id) {
        return new Users()
                .setUserId((int) id)
                .setUserName("不存在" + id + "用户")
                .setUserSources("mysql");

    }

    @ResponseBody
    @RequestMapping(value = "/queryuser", produces = {"application/json;charset=UTF-8"})
    public List queryuser() {

        return this.userServise.queryuserall();
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
