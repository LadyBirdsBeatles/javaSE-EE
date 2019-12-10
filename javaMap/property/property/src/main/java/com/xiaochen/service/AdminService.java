package com.xiaochen.service;

import com.xiaochen.pojo.Admin;

import java.util.List;
import java.util.Map;

public interface AdminService {


    //添加员工
    int insert(Admin record);

    Admin loginAdmin(Admin admin);

    //根据条件查询员工列表
    List<Admin> selectByStatus(Map map);

    //修改动态sql语句
    int updateByPrimaryKeySelective(Admin record);

    Admin getAdmin(String username);
}
