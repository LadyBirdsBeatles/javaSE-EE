package com.xiaochen.goodsmanager.service.GoodsServiceDaoimpl;

import com.xiaochen.goodsmanager.dao.CommonDao;
import com.xiaochen.goodsmanager.dao.GoodsDaoimpl.CommonDaoimpl;
import com.xiaochen.goodsmanager.entity.Goods;
import com.xiaochen.goodsmanager.service.GoodsServiceDao;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

/**
 * 商品
 */
public class GoodsServiceDaoimpl implements GoodsServiceDao {
    private CommonDao commonDao = new CommonDaoimpl();

    @Override
    public boolean goodsadd(Goods goods) throws IllegalAccessException, SQLException, ClassNotFoundException {
        return commonDao.insert(goods);
    }

    @Override
    public boolean goodsdel(Goods goods, Integer id) throws IllegalAccessException, SQLException, ClassNotFoundException {
        return commonDao.delete(goods, id);
    }

    @Override
    public boolean goodsupdate(Goods goods, Integer id) throws IllegalAccessException, SQLException, ClassNotFoundException {
        return commonDao.update(goods, id);
    }

    @Override
    public List goodshows(Goods goods) throws ClassNotFoundException, SQLException, InvocationTargetException, InstantiationException, IllegalAccessException {
        return commonDao.selects(goods);
    }

    /*
    查看信息
  */
    public List goodshow(Goods goods, Integer id) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException, InvocationTargetException {
        return commonDao.select(goods, id);
    }
}
