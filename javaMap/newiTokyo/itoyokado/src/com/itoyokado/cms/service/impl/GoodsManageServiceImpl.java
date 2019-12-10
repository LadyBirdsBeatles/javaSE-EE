package com.itoyokado.cms.service.impl;

import com.itoyokado.cms.dao.GoodsManageDao;
import com.itoyokado.cms.dao.impl.GoodsManageDaoImpl;
import com.itoyokado.cms.entity.Goods;
import com.itoyokado.cms.service.GoodsManageService;

import java.sql.SQLException;
import java.util.List;

public class GoodsManageServiceImpl implements GoodsManageService {
    GoodsManageDao goodsManageDao=new GoodsManageDaoImpl();
    /**
     * 查看所有分类商品名分页书记表格重载
     *
     * @return
     */
    @Override
    public List showname(String name) throws SQLException {
        return goodsManageDao.showname(name);
    }
    /**
     * 查看所有子父分类
     *
     * @return
     */
    @Override
    public List showgoods() throws SQLException {
        return goodsManageDao.showgoods();
    }
    /**
     * 添加数据
     *
     * @param goodsname
     * @return
     */
    @Override
    public boolean addgoods(Goods goodsname) throws SQLException {
        return goodsManageDao.addgoods(goodsname);
    }
    /**
     * 删除数据
     * @param goodsname
     * @return
     */
    @Override
    public boolean delgoods(Goods goodsname) throws SQLException {
        return goodsManageDao.delgoods(goodsname);
    }

    /**
     *
     *修改商品
     * @param goods
     * @return
     */
    @Override
    public boolean updategoods(Goods goods) throws SQLException {
        return goodsManageDao.updategoods(goods);
    }
    /**
     * 父分类下拉框
     *
     * @return
     */
    @Override
    public List foption() throws SQLException {
        return goodsManageDao.foption();
    }

    /**
     * 子分类下拉框
     *
     * @return
     */
    @Override
    public List soption() throws SQLException {
        return goodsManageDao.soption();
    }

}
