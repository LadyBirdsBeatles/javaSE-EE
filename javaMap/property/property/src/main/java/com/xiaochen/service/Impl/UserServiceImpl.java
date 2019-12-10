package com.xiaochen.service.Impl;

import com.xiaochen.mapper.UserMapper;
import com.xiaochen.pojo.User;
import com.xiaochen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("UserService")
public class UserServiceImpl implements UserService {

    private UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }



    //    @Transactional(rollbackFor = Exception.class)
    public User getUser(String username) {
        return userMapper.getUser(username);
    }

    //    @Transactional(rollbackFor = Exception.class)




    @Override
    public User getUserByphone(String phonenumber) {
        return this.userMapper.getUserByphone(phonenumber);
    }

    @Override
    public int updateByPhone(User record) {
        return this.userMapper.updateByPhone(record);
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        return this.userMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<User> selectUser(User user) {

        return this.userMapper.selectUserh(user);
    }
}

