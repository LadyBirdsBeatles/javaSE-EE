package com.itoyokado.cms.dao.impl;

import com.itoyokado.cms.dao.GoodsManageDao;
import com.itoyokado.cms.entity.Goods;
import com.itoyokado.cms.util.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;

import java.sql.SQLException;
import java.util.List;

public class GoodsManageDaoImpl implements GoodsManageDao {
    QueryRunner queryRunner=new QueryRunner(JDBCUtil.getDataSource());
    QueryRunner queryRunners=new QueryRunner();

    /**
     * 查看所有分类商品名分页数据表格重载
     * @param name
     * @return
     * @throws SQLException
     */
    @Override
    public List showname(String name) throws SQLException {
        String sql="SELECT DISTINCT goods.id  g2.statu,g2.parent_id, goods.goods_name, CONCAT( g1.category_name,'-', g2.category_name) as category_name FROM goods, (SELECT category_name,id FROM goods_category ) as g1 LEFT JOIN  goods_category AS g2 on g1.id=g2.parent_id WHERE goods.category_id=g2.id AND  goods.goods_name=?";
        return queryRunners.query(JDBCUtil.getConn(), sql,new MapListHandler(),name);
    }

    /**
     * 查看所有子父分类数据
     * @return
     * @throws SQLException
     */
    @Override
    public List showgoods() throws SQLException {
        String sql="SELECT DISTINCT goods.id,g2.statu,g2.parent_id, goods.goods_name, CONCAT( g1.category_name,'-', g2.category_name) as category_name FROM goods, (SELECT category_name,id FROM goods_category ) as g1 LEFT JOIN  goods_category AS g2 on g1.id=g2.parent_id WHERE goods.category_id=g2.id";
        return queryRunner.query(sql,new MapListHandler());
    }

    /**
     * 添加商品
     * @param goodsname
     * @return
     */
    @Override
    public boolean addgoods(Goods goodsname) throws SQLException {
        String sql = "insert into goods (category_id,goods_name) values(?,?)";
        int update = queryRunner.update(sql, goodsname.getCategory_id(), goodsname.getGoods_name());
        return update>0;
    }

    @Override
    public boolean delgoods(Goods goodsname) throws SQLException {
        String sql="delete from goods where id=?";
        int update = queryRunner.update(sql, goodsname.getId());
        return update>0 ;
    }


    @Override
    public boolean updategoods(Goods goods) throws SQLException {
        String sql="update goods set goods_name = ? where id = ?";
        int update = queryRunner.update(sql, goods.getGoods_name(), goods.getCategory_id());
        return update>0;
    }

    /**
     * 父分类下拉框
     * @return
     * @throws SQLException
     */
    @Override
    public List foption() throws SQLException {
        String sql="SELECT g1.category_name  FROM  (SELECT category_name,id FROM goods_category ) as g1 LEFT JOIN  goods_category AS g2 on g1.id=g2.parent_id";
        return queryRunners.query( JDBCUtil.getConn(),sql,new MapListHandler());
    }

    /**
     * 子分类下拉框
     * @return
     * @throws SQLException
     */
    @Override
    public List soption() throws SQLException {
        String sql="SELECT g2.category_name  FROM  (SELECT category_name,id FROM goods_category ) as g1 LEFT JOIN  goods_category AS g2 on g1.id=g2.parent_id";
        return queryRunners.query(JDBCUtil.getConn(),sql,new MapListHandler());
    }
}
