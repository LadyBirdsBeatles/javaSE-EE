package com.xiaochen.service;

import com.xiaochen.pojo.Msg;

import java.util.List;
import java.util.Map;

public interface MsgService {
    //发布列表显示
    List<Msg> select(Map map);

    //添加信息
    int insertSelective(Msg record);

    //修改信息
    int updateByPrimaryKeySelective(Msg record);
}
