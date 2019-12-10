package com.xiaochen.goodsmanager.service.GoodsServiceDaoimpl;

import com.xiaochen.goodsmanager.dao.CommonDao;
import com.xiaochen.goodsmanager.dao.GoodsDaoimpl.CommonDaoimpl;
import com.xiaochen.goodsmanager.entity.Particulars;
import com.xiaochen.goodsmanager.service.ParticularsServiceDao;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

public class ParticularsServiceDaoimp implements ParticularsServiceDao {
    private CommonDao commonDao=new CommonDaoimpl();
    @Override
    public boolean particadd(Particulars particulars) throws IllegalAccessException, SQLException, ClassNotFoundException {
        return  commonDao.insert(particulars);
    }

    @Override
    public boolean particdel(Particulars particulars, Integer id) throws IllegalAccessException, SQLException, ClassNotFoundException {
        return commonDao.delete(particulars,id);
    }

    @Override
    public boolean particupdate(Particulars particulars, Integer id) throws IllegalAccessException, SQLException, ClassNotFoundException {
        return commonDao.update(particulars,id);
    }

    @Override
    public List particshow(Particulars particulars) throws ClassNotFoundException, SQLException, InvocationTargetException, InstantiationException, IllegalAccessException {
        return commonDao.selects(particulars);
    }
}
