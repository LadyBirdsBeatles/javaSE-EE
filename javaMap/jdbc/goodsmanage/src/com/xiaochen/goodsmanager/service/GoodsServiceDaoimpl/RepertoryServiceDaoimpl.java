package com.xiaochen.goodsmanager.service.GoodsServiceDaoimpl;

import com.xiaochen.goodsmanager.dao.CommonDao;
import com.xiaochen.goodsmanager.dao.GoodsDaoimpl.CommonDaoimpl;
import com.xiaochen.goodsmanager.entity.Repertory;
import com.xiaochen.goodsmanager.service.RepertoryServiceDao;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

public class RepertoryServiceDaoimpl implements RepertoryServiceDao {
    private CommonDao commonDao=new CommonDaoimpl();
    @Override
    public boolean repertoryadd(Repertory repertory) throws IllegalAccessException, SQLException, ClassNotFoundException {
        return commonDao.insert(repertory);
    }

    @Override
    public boolean repertorydel(Repertory repertory ,Integer id) throws IllegalAccessException, SQLException, ClassNotFoundException {
        return commonDao.delete(repertory,id);
    }

    @Override
    public boolean repertoryupdate(Repertory repertory ,Integer id) throws IllegalAccessException, SQLException, ClassNotFoundException {
        return commonDao.update(repertory,id);
    }

    @Override
    public List repertoryshows(Repertory repertory) throws ClassNotFoundException, SQLException, InvocationTargetException, InstantiationException, IllegalAccessException {
        return  commonDao.selects(repertory);
    }
    @Override
    public List repertoryshow(Repertory repertory, Integer id) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException, InvocationTargetException {
        return commonDao.select(repertory,id);
    }
}
