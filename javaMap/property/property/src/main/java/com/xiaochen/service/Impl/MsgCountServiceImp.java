package com.xiaochen.service.Impl;

import com.xiaochen.mapper.MsgCountMapper;
import com.xiaochen.pojo.MsgCount;
import com.xiaochen.service.MsgCountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("MsgCountService")
public class MsgCountServiceImp implements MsgCountService {


    @Resource
    MsgCountMapper msgCountMapper;

    @Override
    public int insertSelective(MsgCount record) {
        return msgCountMapper.insertSelective(record);
    }

    @Override
    public MsgCount selectByPrimaryKey(MsgCount record) {
        return msgCountMapper.selectByPrimaryKey(record);
    }

    @Override
    public int updateByPrimaryKeySelective(MsgCount record) {
        return msgCountMapper.updateByPrimaryKeySelective(record);
    }
}
