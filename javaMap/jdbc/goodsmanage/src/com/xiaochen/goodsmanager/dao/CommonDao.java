package com.xiaochen.goodsmanager.dao;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

/**
 * 通用数据库操作
 */
public interface CommonDao {
    /**
     * 添加
     * @param <T>
     * @return
     * @throws SQLException
     * @throws IllegalAccessException
     * @throws ClassNotFoundException
     */
    public <T>  boolean insert(T t) throws SQLException, IllegalAccessException, ClassNotFoundException;

    /**
     * 删除
     * @param t
     * @param <T>
     * @return
     */
    public <T, U> boolean  delete(T t,U u) throws SQLException, ClassNotFoundException, IllegalAccessException;
    /**
     * 修改
     * @param t
     * @param <T>
     * @return
     */
    public <T, U> boolean  update(T t,U u) throws SQLException, IllegalAccessException, ClassNotFoundException;

    /**
     * 查询所有
     * @param <T>
     * @param t
     * @return
     */
    public <T> List selects(T t) throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException;

    /**
     * 查询单个
     * @param <T>
     * @param <U>
     * @param t
     * @param u
     * @return
     */
    public <T,U> List select(T t, U u) throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException;


}

