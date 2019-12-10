package com.xiaochen.mapper;

import com.xiaochen.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    /**
     * 按id查询用户
     *
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

    /**
     * 查询所有用户
     *
     * @param map
     * @return
     */
    List<User> ccSelectAll(Map map);

    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    int ccInsert(User user);

    /**
     * 修改业主账户
     *
     * @param user
     * @return
     */
    int ccUpdate(User user);

    /**
     * 删除业主账户
     *
     * @param list
     * @return
     */
    int ccDelete(List list);

    List<User> selectUser(Map map);

    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updatepassword(User record);

    int updateByPrimaryKey(User record);

    List<User> selectUserh(User user);

    int updateByPhone(User record);//通过电话重置密码

    User getUserByphone(String phonenumber);//通过电话查找用户

    User getUser(String username);

//    User loginUser(User user);
}