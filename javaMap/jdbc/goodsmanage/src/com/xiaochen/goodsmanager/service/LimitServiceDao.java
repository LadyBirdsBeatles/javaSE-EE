package com.xiaochen.goodsmanager.service;

import com.xiaochen.goodsmanager.entity.Pagelimit;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

public interface LimitServiceDao {
    /**
     * 查看记录
     */
    public <T, U> List Limit(T t, U u) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException;

    /**
     *  分页通用
     */
    public <T> Pagelimit pageLimit(T t, Integer pageNumber, Integer pageSize) throws ClassNotFoundException, SQLException, InvocationTargetException, InstantiationException, IllegalAccessException;
}
