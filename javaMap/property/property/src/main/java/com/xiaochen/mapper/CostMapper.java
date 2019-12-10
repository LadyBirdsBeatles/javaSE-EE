package com.xiaochen.mapper;

import com.xiaochen.pojo.Cost;

import java.util.List;
import java.util.Map;

public interface CostMapper {
    /**
     * 查询所有
     *
     * @return
     */
    List<Cost> ccSelectAll(Map map);

    /**
     * 录入缴费表信息
     *
     * @param cost
     * @return
     */
    int ccInsert(Cost cost);

    /**
     * 按用户和时间查询
     *
     * @param map
     * @return
     */
    Cost ccSelectByUserDate(Map map);

    /**
     * 修改账单
     *
     * @param cost
     * @return
     */
    int ccUpdate(Cost cost);

    /**
     * 查询缴费
     *
     * @param map
     * @return
     */
    List<Cost> ccSelectPay(Map map);

    /**
     * 按id查询
     *
     * @param id
     * @return
     */
    Cost ccSelectById(int id);

    /**
     * 修改账单
     *
     * @param id
     * @return
     */
    int ccUpdateState(int id);

    int deleteByPrimaryKey(Integer costId);

    int insert(Cost record);

    int insertSelective(Cost record);

    Cost selectByPrimaryKey(Integer costId);

    int updateByPrimaryKeySelective(Cost record);

    int updateByPrimaryKey(Cost record);

    /*缴费单*/
    public List<Cost> selectcostlist(Map map);

    /*缴费成功的账单*/
    public List<Cost> selectcostsuccess(int id);
}