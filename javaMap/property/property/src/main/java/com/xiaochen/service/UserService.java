package com.xiaochen.service;

import com.xiaochen.pojo.User;

import java.util.List;

public interface UserService {

    public User getUser(String username);//1
    User getUserByphone(String phonenumber);//通过电话查找用户//1.
    int updateByPrimaryKeySelective(User record);
    List<User> selectUser(User user);



    int updateByPhone(User record);//通过电话重置密码
}
