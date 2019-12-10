package com.xiaochen.goodsmanager.dao;

import com.xiaochen.goodsmanager.entity.Admin;
import com.xiaochen.goodsmanager.entity.Pagelimit;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

public interface Logindao {
    /**
     * admin登陆
     * @param admin
     * @return
     */
    public Admin adminlogin(Admin admin) throws SQLException, ClassNotFoundException;
    /**
     * 分页通用
     * @return
     */
    public <T, U> List Limit(T t, U u) throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException;

    /**
     * 智能单表查询分页
     * @param pageNumber
     * @param pageSize
     * @param <T>
     * @param <U>
     * @return
     */
    public <T> Pagelimit pageLimit(T t, Integer  pageNumber, Integer pageSize ) throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException;
}
