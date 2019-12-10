package com.xiaochen.mapper;

import com.xiaochen.pojo.MsgCount;

public interface MsgCountMapper {

    int insertSelective(MsgCount record);

    MsgCount selectByPrimaryKey(MsgCount record);

    int updateByPrimaryKeySelective(MsgCount record);



}