package com.xiaochen.goodsmanager.service;

import com.xiaochen.goodsmanager.entity.Repertory;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

/**
 * 详情
 */
public interface RepertoryServiceDao {
    /*
    add库存
     */
    public boolean repertoryadd(Repertory repertory) throws IllegalAccessException, SQLException, ClassNotFoundException;
    /*
    清除库存
     */
    public  boolean  repertorydel(Repertory repertory,Integer id) throws IllegalAccessException, SQLException, ClassNotFoundException;
    /*
     修改库存
    */
    public  boolean  repertoryupdate(Repertory repertory ,Integer id) throws IllegalAccessException, SQLException, ClassNotFoundException;
    /*
    查看所有库存
     */
    public List repertoryshows(Repertory repertory) throws ClassNotFoundException, SQLException, InvocationTargetException, InstantiationException, IllegalAccessException;
    /*
    查看库存
     */
    public List repertoryshow(Repertory repertory, Integer id) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException, InvocationTargetException;
}
