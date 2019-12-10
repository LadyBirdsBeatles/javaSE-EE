package com.xiaochen.service.Impl;

import com.xiaochen.mapper.UserMapper;
import com.xiaochen.pojo.User;
import com.xiaochen.service.CCUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class CCUserServiceImpl implements CCUserService {
    @Resource
    UserMapper mapper;


    @Override
    public List<User> ccGetAll(Map map) {
        return mapper.ccSelectAll(map);
    }



    @Override
    public int ccAdd(User user) {
        return mapper.ccInsert(user);
    }

    @Override
    public int ccUpdate(User user) {
        return mapper.ccUpdate(user);
    }

    @Override
    public int ccDelete(List list) {
        return mapper.ccDelete(list);
    }

    @Override
    public User ccSelectById(int id) {
        return mapper.ccSelectById(id);
    }

    @Override
    public User ccSelectByUser(User user) {
        return mapper.ccSelectByUser(user);
    }
}
