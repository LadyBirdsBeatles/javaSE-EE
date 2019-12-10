package com.cloud.beetles.servise.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cloud.beetles.dao.UserMapper;
import com.cloud.beetles.servise.UserServise;
import com.cloud.beetles.pojo.Users;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
public class UserServiseImpl implements UserServise {
    @Autowired
    private UserMapper userDao;
    @Override
    public boolean adduser(String user) {
        JSONObject jsonObject = JSON.parseObject(user);
        Users users = new Users();
        users.setUserName(jsonObject.getString("username"));
        users.setUserPassword(jsonObject.getString("userpassword"));
        users.setUserPhonenumber(jsonObject.getString("userphonenuber"));
        return userDao.adduser(users);
    }

    @Override
    public Users queryuserid(long id) {
        return userDao.queryuserid(id);
    }

    @Override
    public List<Users> queryuser() {
        return userDao.queryuser();
    }

}
