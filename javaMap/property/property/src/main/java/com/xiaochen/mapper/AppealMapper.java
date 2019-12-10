package com.xiaochen.mapper;

import com.xiaochen.pojo.Appeal;

import java.util.List;
import java.util.Map;

public interface AppealMapper {
    /**
     * 按id查询投诉表
     * @param id
     * @return
     */
    Appeal ccSelectById(int id);

    /**
     * 查询所有投诉表
     * @param map
     * @return
     */
    List<Appeal> ccSelectAll(Map map);

    /**
     * 修改投诉表处理人员
     * @param map
     * @return
     */
    int ccUpdateAdmin(Map map);

    /**
     * 修改投诉表状态
     * @param appeal
     * @return
     */
    int ccUpdateState(Appeal appeal);
    int deleteByPrimaryKey(Integer appealId);

    /*添加投诉*/
    int insert(Appeal record);

    int insertSelective(Appeal record);

    Appeal selectByPrimaryKey(Integer appealId);

    int updateByPrimaryKeySelective(Appeal record);

    int updateByPrimaryKey(Appeal record);

    /**
     * 未处理的投诉
     * @param id
     * @return
     */
    List<Appeal> nocomplain(int id);

    /**
     * 已处理的投诉
     * @param map
     * @return
     */
    List<Appeal> pastcomplain(Map map);

    /**
     * 未处理的投诉结果回复
     *
     * @param id
     * @return
     */
    Appeal nocomplainresult(int id);

    /**
     * 已处理的投诉结果
     *
     * @param id
     * @return
     */
    Appeal pastcomplainresult(int id);
}