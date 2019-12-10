package com.xiaochen.goodsmanager.service;

import com.xiaochen.goodsmanager.entity.Goods;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

public interface GoodsServiceDao {

    /*
    上架商品
     */
    public boolean goodsadd(Goods goods) throws IllegalAccessException, SQLException, ClassNotFoundException;
    /*
    下架商品
     */
    public boolean goodsdel(Goods goods, Integer id) throws IllegalAccessException, SQLException, ClassNotFoundException;
    /*
   修改商品信息
    */
    public boolean goodsupdate(Goods goods , Integer id) throws IllegalAccessException, SQLException, ClassNotFoundException;
    /*
    查看所有员工信息
     */
    public List goodshows(Goods goods) throws ClassNotFoundException, SQLException, InvocationTargetException, InstantiationException, IllegalAccessException;
    /*
    查看员工信息
     */
    public List goodshow(Goods goods, Integer id) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException, InvocationTargetException;

}
