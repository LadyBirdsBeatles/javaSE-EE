package com.xiaochen.service;


import com.xiaochen.pojo.Appeal;
import com.xiaochen.pojo.Reply;
import net.sf.json.JSONObject;

import java.util.Map;

public interface LAppealService {
    int deleteByPrimaryKey(Integer appealId);

    /*添加投诉*/
    int insert(Appeal record);

    /*未处理的投诉*/
    JSONObject nocomplain(int id);

    /*已处理的投诉*/
    JSONObject pastcomplain(Map map);
    /*添加投诉*/
    int insertSelective(Appeal record);

    Appeal selectByPrimaryKey(Integer appealId);

    int updateByPrimaryKeySelective(Appeal record);

    int updateByPrimaryKey(Appeal record);

    /**
     * 未处理的投诉结果回复
     *
     * @param id
     * @return
     */
    Map nocomplainresult(int id);

    /**
     * 已处理的投诉结果
     *
     * @param id
     * @return
     */
    Map pastcomplainresult(int id);

    /**
     * 投诉回复
     */
    int cflInsert(Reply record);

    /**
     * 评价
     *
     * @param appeal
     * @return
     */
    int updatestateappeal(Appeal appeal);
}
