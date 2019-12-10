package com.cloud.beetles.controller;

import com.cloud.beetles.pojo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * 客服端
 */
@Controller
@RequestMapping("/consumer")
public class UserConsumerController {
    @Autowired
    private RestTemplate restTemplate;
   /* private static final String REST_URL = "http://localhost:8001";*/
    private static final String REST_URL = "http://SPRINGCLOUD-PROVIDER-USER";
    @ResponseBody
    @RequestMapping(value = "/adduser")
    public boolean adduser(String user) {
        return restTemplate.postForObject(REST_URL + "/user/adduser", user, Boolean.class);
    }

    @ResponseBody
    @RequestMapping("/queryuid")
    public Users queryuid(long id) {
        return restTemplate.getForObject(REST_URL + "/user/queryuid/"+id, Users.class);
    }

    @ResponseBody
    @RequestMapping("/queryuser")
    public List queryuser() {
        return restTemplate.getForObject(REST_URL + "/user/queryuser", List.class);
    }
}
