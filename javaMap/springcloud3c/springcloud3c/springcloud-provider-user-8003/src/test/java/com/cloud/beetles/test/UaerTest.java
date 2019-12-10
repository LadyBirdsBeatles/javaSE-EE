package com.cloud.beetles.test;


import com.cloud.beetles.dao.UserMapper;
import com.cloud.beetles.pojo.Users;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.xml.transform.Source;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UaerTest {
    @Autowired
    private UserMapper mapper;

    @Before
    public void before() {

    }

    @Test
    public void getuser() {
        List<Users> queryuser = mapper.queryuser();
        Users queryuserid = mapper.queryuserid(1);
        Users users = new Users();
        users.setUserName("beetles");
        users.setUserPassword("admin");
        users.setUserPhonenumber("15983019221");
        boolean adduser = mapper.adduser(users);
        System.out.println(adduser);

    }
}

