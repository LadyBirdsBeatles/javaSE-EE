package com.itoyokado.cms.dao.impl;

import com.itoyokado.cms.dao.CategoryDao;
import com.itoyokado.cms.entity.Goods_Category;
import com.itoyokado.cms.util.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class CategoryDaoImpl implements CategoryDao {
    /**
     * 查询分类总数
     * @return
     * @throws SQLException
     */
    @Override
    public int findCateCount() throws SQLException {
        String sql = "SELECT count(*) FROM goods_category WHERE parent_id !=0";
        QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());
        Long count = (Long)queryRunner.query(sql, new ScalarHandler<>());
        return count.intValue();
    }

    /**
     * 查询分类信息
     * @param page
     * @param limit
     * @param name
     * @return
     * @throws SQLException
     */
    @Override
    public List<Map<String, Object>> findCateByPageAndlimit(int page, int limit, String name) throws SQLException {
        //查询分类信息 分类状态
        String sql = "SELECT g1.category_name name,g1.id id,g1.statu zstatu, g2.category_name parent_name,g2.id parent_id,g2.statu fstatu FROM goods_category g1 LEFT JOIN goods_category g2 ON  g1.parent_id = g2.id WHERE g1.parent_id !=0 ORDER BY g1.id DESC LIMIT ?,?";
        List<Map<String, Object>> list = null;
        QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());
        if (name != null){
            sql = "SELECT g1.category_name name,g1.id id,g1.statu zstatu, g2.category_name parent_name,g2.id parent_id,g2.statu fstatu FROM goods_category g1 LEFT JOIN goods_category g2 ON  g1.parent_id = g2.id WHERE (g1.category_name like concat('%',?,'%') OR g2.category_name like concat('%',?,'%')) AND g1.parent_id !=0  ORDER BY g1.id DESC LIMIT ?,?";
            list = queryRunner.query(sql, new MapListHandler(),name,name,(page - 1) * limit, limit);
        }else {
            list = queryRunner.query(sql, new MapListHandler(), (page - 1) * limit, limit);
        }
        return list;
    }

    @Override
    public int updateStatu(int id, String statu) throws SQLException {
        int sta = Integer.parseInt(statu);
        String sql = "update goods_category set statu=? where id=?";
        QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());
        return queryRunner.update(sql,sta,id);
    }

    /**
     * 查询指定的分类名 模糊查询
     * @param name
     * @return
     */
    @Override
    public int findCateCount(String name) throws SQLException {
        String sql = "SELECT count(*) FROM goods_category WHERE parent_id !=0 and category_name like concat('%',?,'%')";
        QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());
        Long count = (Long)queryRunner.query(sql, new ScalarHandler<>(),name);
        System.out.println("查询到的"+count);
        return count.intValue();
    }

    @Override
    public List<Goods_Category> findParentCate() throws SQLException {
        String sql = "select * from goods_category where parent_id=0 AND id !=0";
        QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());
        return queryRunner.query(sql,new BeanListHandler<Goods_Category>(Goods_Category.class));
    }

    @Override
    public int addCateByparentId(int parent_id, String category_name) throws SQLException {
        String sql = "insert goods_category values(null,?,?,1)";
        QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());
        return queryRunner.update(sql,category_name,parent_id);
    }
}
