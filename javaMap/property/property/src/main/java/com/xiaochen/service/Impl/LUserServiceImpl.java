package com.xiaochen.service.Impl;

import com.xiaochen.mapper.UserMapper;
import com.xiaochen.pojo.User;
import com.xiaochen.service.LUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("lUserService")
public class LUserServiceImpl implements LUserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> selectuser(Map map) {
        return userMapper.selectUser(map);
    }

    @Override
    public User ccSelectById(int id) {
        return null;
    }

    @Override
    public int deleteByPrimaryKey(Integer userId) {
        return 0;
    }

    @Override
    public int insert(User record) {
        return 0;
    }

    @Override
    public int insertSelective(User record) {
        return 0;
    }

    @Override
    public User selectByPrimaryKey(Integer userId) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {

        return userMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return 0;
    }

    @Override
    public List<User> selectUser() {
        return null;
    }

    @Override
    public User getUser(String username) {
        return null;
    }

    @Override
    public void regUser(String username, String password) {

    }
}
