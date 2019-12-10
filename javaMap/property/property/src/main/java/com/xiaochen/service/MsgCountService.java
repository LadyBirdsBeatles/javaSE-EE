package com.xiaochen.service;

import com.xiaochen.pojo.MsgCount;


public interface MsgCountService {

    int insertSelective(MsgCount record);

    MsgCount selectByPrimaryKey(MsgCount record);

    int updateByPrimaryKeySelective(MsgCount record);
}
