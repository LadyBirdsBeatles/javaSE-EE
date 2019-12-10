package com.xiaochen.goodsmanager.service;

import com.xiaochen.goodsmanager.entity.Particulars;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

public interface ParticularsServiceDao {
    /*
    添加详情
     */
    public boolean particadd(Particulars particulars) throws IllegalAccessException, SQLException, ClassNotFoundException;
    /*
    删除详情
     */
    public boolean particdel(Particulars particulars, Integer id) throws IllegalAccessException, SQLException, ClassNotFoundException;
    /*
   修改详情
    */
    public  boolean  particupdate(Particulars particulars, Integer id) throws IllegalAccessException, SQLException, ClassNotFoundException;
    /*
    查看险情
     */
    public List particshow(Particulars particulars) throws ClassNotFoundException, SQLException, InvocationTargetException, InstantiationException, IllegalAccessException;
}
