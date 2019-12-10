package com.cloud.beetles.controller;

import com.cloud.beetles.pojo.Users;
import com.cloud.beetles.service.UserClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.List;

/**
 * 客服端
 */
@Controller
@RequestMapping("/consumer")
public class UserConsumerControllerFeign {
    @Autowired
    private UserClientService service;

    @ResponseBody
    @RequestMapping(value = "/adduser")
    public boolean adduser(Users user) {
        return this.service.adduser(user);
    }

    @ResponseBody
    @RequestMapping("/queryuid")
    public Users queryuid(long id) {
        return this.service.queryuser(id);
    }

    @ResponseBody
    @RequestMapping("/queryuser")
    public List queryuser() {
        return this.service.queryuserall();

    }
}
