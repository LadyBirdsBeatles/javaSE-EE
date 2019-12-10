package com.xiaochen.service;


import com.xiaochen.pojo.Repair;
import com.xiaochen.pojo.Reply;
import net.sf.json.JSONObject;

import java.util.Map;

public interface LRepairService {
    int deleteByPrimaryKey(Integer repairId);

    int insert(Repair record);

    int insertSelective(Repair record);

    Repair selectByPrimaryKey(Integer repairId);

    int updateByPrimaryKeySelective(Repair record);

    int updateByPrimaryKey(Repair record);

    /* 未处理*/
    JSONObject showrepair(int uid);

    /* 未处理回复*/
    public Map nopairresult(int uid);

    /*以处理*/
    JSONObject pastepair(Map map);

    /* 以处理回复*/
    public Map psatpairresult(int uid);

    int clInsert(Reply record);

   int  updateestimate(Repair record);
}
