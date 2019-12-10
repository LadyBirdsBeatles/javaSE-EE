package com.xiaochen.goodsmanager.service;

import com.xiaochen.goodsmanager.entity.Admin;
import com.xiaochen.goodsmanager.entity.Employee;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

/**
 * 业务层
 */
public interface ManageServiceDao {
    /*
     * Admin登陆
     */
    public  int adminlogin(Admin admin) throws SQLException, ClassNotFoundException;

    /*
    员工添加
     */
    public boolean empadd(Employee employee) throws IllegalAccessException, SQLException, ClassNotFoundException;
    /*
    删除员工
     */
    public boolean empdel(Employee employee, Integer id) throws IllegalAccessException, SQLException, ClassNotFoundException;
    /*
   修改员工信息
    */
    public boolean empupdate(Employee employee , Integer id) throws IllegalAccessException, SQLException, ClassNotFoundException;
    /*
    查看所有员工信息
     */
    public List empshows(Employee employee) throws ClassNotFoundException, SQLException, InvocationTargetException, InstantiationException, IllegalAccessException;
    /*
    查看员工信息
     */
    public List empshow(Employee employee, Integer id) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException, InvocationTargetException;
}
