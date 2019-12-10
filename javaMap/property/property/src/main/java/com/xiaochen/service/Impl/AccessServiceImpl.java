package com.xiaochen.service.Impl;

import com.xiaochen.mapper.AccessMapper;
import com.xiaochen.pojo.Access;
import com.xiaochen.service.AccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("AccessService")
public class AccessServiceImpl implements AccessService {

    private AccessMapper accessMapper;

    @Autowired
    public AccessServiceImpl(AccessMapper accessMapper){
        this.accessMapper = accessMapper;
    }


    @Override
    public int insertAccess(Access access) {
        return this.accessMapper.insertAccess(access);
    }

    @Override
    public int updateAccess(Access access) {
        return this.accessMapper.updateAccess(access);
    }

    @Override
    public List<Access> selectAccessList(Map maps) {
        return this.accessMapper.selectAccessList(maps);
    }

    @Override
    public List<Access> selectAccess(Access access) {
        return this.accessMapper.selectAccess(access);
    }
}
