package com.xiaochen.goodsmanager.service.GoodsServiceDaoimpl;
import com.xiaochen.goodsmanager.dao.GoodsDaoimpl.Logindaoimpl;
import com.xiaochen.goodsmanager.dao.Logindao;
import com.xiaochen.goodsmanager.entity.Pagelimit;
import com.xiaochen.goodsmanager.service.LimitServiceDao;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

public class LimitServiceDaoimpl implements LimitServiceDao {
    Logindao logindao=new Logindaoimpl();
    @Override
    public <T, U> List Limit(T t,U u) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        return logindao.Limit(t, u);
    }

    /**
     * 单表查询分页
     * @param t
     * @param pageNumber
     * @param pageSize
     * @param <T>
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     * @throws InvocationTargetException
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    @Override
    public <T> Pagelimit pageLimit(T t, Integer pageNumber, Integer pageSize) throws ClassNotFoundException, SQLException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Pagelimit pageBean = logindao.pageLimit(t, pageNumber, pageSize);
        return pageBean;
    }
}
