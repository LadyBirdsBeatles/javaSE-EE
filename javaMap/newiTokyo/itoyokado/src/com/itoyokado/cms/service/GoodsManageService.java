package com.itoyokado.cms.service;

import com.itoyokado.cms.entity.Goods;

import java.sql.SQLException;
import java.util.List;

public interface GoodsManageService {
    /**
     * 查看所有分类商品名分页书记表格重载
     *
     * @return
     */
    public List showname(String name) throws SQLException;

    /**
     * 查看所有子父分类
     *
     * @return
     */
    public List showgoods() throws SQLException;
    /**
     * 添加数据
     *
     * @param goodsname
     * @return
     */

    public boolean addgoods(Goods goodsname) throws SQLException;

    /**
     * 删除商品
     * @param goodsname
     * @return
     */
    public boolean delgoods(Goods goodsname) throws SQLException;
    /**
     *
     *修改商品
     * @param goods
     * @return
     */
    public boolean updategoods(Goods goods) throws SQLException;

    /**
     * 父分类下拉框
     *
     * @return
     */
    public List foption() throws SQLException;

    /**
     * 子分类下拉框
     *
     * @return
     */
    public List soption() throws SQLException;
}

