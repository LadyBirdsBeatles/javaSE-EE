package com.xiaochen.mapper;

import com.xiaochen.pojo.Msg;

import java.util.List;
import java.util.Map;

public interface MsgMapper {


    //添加信息
    int insertSelective(Msg record);

    //修改信息
    int updateByPrimaryKeySelective(Msg record);

    //发布列表显示
    List<Msg> select(Map map);

    int deleteByPrimaryKey(Integer msgId);

    int insert(Msg record);


    Msg selectByPrimaryKey(Integer msgId);


    int updateByPrimaryKey(Msg record);

    List<Msg> showmsg(Map map);
}