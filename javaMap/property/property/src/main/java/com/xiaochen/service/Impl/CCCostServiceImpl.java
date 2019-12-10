package com.xiaochen.service.Impl;

import com.xiaochen.mapper.CostMapper;
import com.xiaochen.mapper.PayMapper;
import com.xiaochen.mapper.UserMapper;
import com.xiaochen.pojo.Cost;
import com.xiaochen.pojo.Pay;
import com.xiaochen.pojo.User;
import com.xiaochen.service.CCCostService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class CCCostServiceImpl implements CCCostService {
    @Resource
    CostMapper mapper;

    @Resource
    UserMapper userMapper;

    @Resource
    PayMapper payMapper;

    @Override
    public List<Cost> ccGetAll(Map map) {
        return mapper.ccSelectAll(map);
    }

    @Override
    public User ccGetUser(User user) {
        return userMapper.ccSelectByUser(user);
    }

    @Override
    public int ccAdd(Cost cost) {
        return mapper.ccInsert(cost);
    }

    @Override
    public Cost ccGetCostByUserDate(Map map) {
        return mapper.ccSelectByUserDate(map);
    }

    @Override
    public int ccUpdate(Cost cost) {
        return mapper.ccUpdate(cost);
    }

    @Override
    public List<Cost> ccGetPay(Map map) {
        return mapper.ccSelectPay(map);
    }

    @Override
    public Cost ccGetCost(int id) {
        return mapper.ccSelectById(id);
    }

    @Override
    public int ccUpdateState(int id) {
        return mapper.ccUpdateState(id);
    }

    @Override
    public int ccAddPay(Pay pay) {
        return payMapper.ccInsertPay(pay);
    }

    @Override
    public List<Pay> ccGetPayAll(Map map) {
        return payMapper.ccSelectAll(map);
    }
}
