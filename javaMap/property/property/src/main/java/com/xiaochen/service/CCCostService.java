package com.xiaochen.service;

import com.xiaochen.pojo.Cost;
import com.xiaochen.pojo.Pay;
import com.xiaochen.pojo.User;

import java.util.List;
import java.util.Map;

public interface CCCostService {
    /**
     * 查询所有
     * @return
     */
    List<Cost> ccGetAll(Map map);

    /**
     * 按手机号查询用户
     * @param user
     * @return
     */
    User ccGetUser(User user);

    /**
     * 添加账单
     * @param cost
     * @return
     */
    int ccAdd(Cost cost);

    /**
     * 按用户和时间查询
     * @param map
     * @return
     */
    Cost ccGetCostByUserDate(Map map);

    /**
     * 修改账单
     * @param cost
     * @return
     */
    int ccUpdate(Cost cost);


    /**
     * 查询缴费
     * @param map
     * @return
     */
    List<Cost> ccGetPay(Map map);

    /**
     * 按id查询
     * @param id
     * @return
     */
    Cost ccGetCost(int id);

    /**
     * 修改账单
     * @param id
     * @return
     */
    int ccUpdateState(int id);

    /**
     * 添加缴费记录
     * @param pay
     * @return
     */
    int ccAddPay(Pay pay);

    /**
     * 查询缴费记录
     *
     * @param map
     * @return
     */
    List<Pay> ccGetPayAll(Map map);
}
