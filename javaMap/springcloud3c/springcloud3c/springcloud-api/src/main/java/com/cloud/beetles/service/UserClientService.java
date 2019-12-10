package com.cloud.beetles.service;

import com.cloud.beetles.pojo.Users;
import com.cloud.beetles.service.Impl.UserClientServiceFallbackFactory;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Component
@FeignClient(value = "SPRINGCLOUD-PROVIDER-USER",fallbackFactory = UserClientServiceFallbackFactory.class)
public interface UserClientService {
    @RequestMapping("user/adduser")
    public boolean adduser(Users users);

    @RequestMapping("user/queryuid")
    public Users queryuser(@PathVariable("id") long id);

    @RequestMapping("user/queryuser")
    public List queryuserall();
}
