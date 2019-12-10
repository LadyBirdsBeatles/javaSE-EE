package com.xiaochen.service;

import com.xiaochen.pojo.User;

import java.util.List;
import java.util.Map;

public interface CCUserService {
    /**
     * 查询所有用户
     * @param map
     * @return
     */
    List<User> ccGetAll(Map map);

    /**
     * 添加用户
     * @param user
     * @return
     */
    int ccAdd(User user);

    /**
     * 修改业主账户
     * @param user
     * @return
     */
    int ccUpdate(User user);

    /**
     * 删除业主账户
     * @param list
     * @return
     */
    int ccDelete(List list);


    /**
     * 按id查询用户
     * @param id
     * @return
     */
    User ccSelectById(int id);

    /**
     * 按手机号查询用户
     *
     * @param user
     * @return
     */
    User ccSelectByUser(User user);
}
