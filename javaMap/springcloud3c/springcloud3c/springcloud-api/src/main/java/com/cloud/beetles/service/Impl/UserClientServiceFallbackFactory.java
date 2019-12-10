package com.cloud.beetles.service.Impl;

import com.cloud.beetles.pojo.Users;
import com.cloud.beetles.service.UserClientService;
import feign.hystrix.FallbackFactory;

import java.util.List;

/**
 * 降级使用
 */
public class UserClientServiceFallbackFactory implements FallbackFactory {
    @Override
    public UserClientService create(Throwable throwable) {
        return new UserClientService() {
            @Override
            public boolean adduser(Users users) {
                return false;
            }

            @Override
            public Users queryuser(long id) {
                return new Users().setUserId((int)id).setUserName("no"+id+"降级了");
            }

            @Override
            public List queryuserall() {
                return null;
            }
        };
    }


}
