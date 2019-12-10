package com.xiaochen.mapper;

import com.xiaochen.pojo.Pay;

import java.util.List;
import java.util.Map;

public interface PayMapper {
    /**
     * 添加缴费记录
     *
     * @param pay
     * @return
     */
    int ccInsertPay(Pay pay);

    /**
     * 查询缴费记录
     *
     * @param map
     * @return
     */
    List<Pay> ccSelectAll(Map map);

    int deleteByPrimaryKey(Integer payId);

    int insert(Pay record);

    int insertSelective(Pay record);

    Pay selectByPrimaryKey(Integer payId);

    int updateByPrimaryKeySelective(Pay record);

    int updateByPrimaryKey(Pay record);

    List<Pay> clSelectPay(int id);

    /**
     * 缴费账单
     */

    List<Pay> clSelectAccontPays(Map map);
}