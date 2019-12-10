package com.xiaochen.mapper;

import com.xiaochen.pojo.Admin;

import java.util.List;
import java.util.Map;

public interface AdminMapper {

    //添加员工
    int insert(Admin record);


    //根据条件查询员工列表
    List<Admin> selectByStatus(Map map);

    //修改动态sql语句
    int updateByPrimaryKeySelective(Admin record);

    /**
     * 按id查询维修人员
     * @param id
     * @return
     */
    Admin ccSelectByIdWX(int id);

    /**
     * 查询所有客服
     *
     * @return
     */
    List<Admin> ccSelectAllKF();

    /**
     * 查询所有维修人员
     * @return
     */
    List<Admin> ccSelectAllWX();


    Admin loginAdmin(Admin admin);

    Admin getAdmin(String username);
}