package com.itoyokado.cms.dao.impl;

import com.itoyokado.cms.dao.mapDao;
import com.itoyokado.cms.entity.B_Map;
import com.itoyokado.cms.util.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class mapDaoImpl implements mapDao {
    QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());
    QueryRunner queryRunners=new QueryRunner();

    /**
     * 显示配送范围
     *
     * @return
     * @throws SQLException
     */
    @Override
    public List<B_Map> selectAll() throws SQLException {
        String sql = "select * from map";
        return queryRunner.query(sql,new BeanListHandler<>(B_Map.class));
    }

    /**
     * 实现查找指定配送范围
     * 用户输入的坐标范围的颜色
     *
     * @param mapName
     * @return
     * @throws SQLException
     */
    @Override
    public List<B_Map> selectCoordinate(String mapName) throws SQLException {
        String sql = "select * from map where mapName=?";
        return queryRunner.query(sql, new BeanListHandler<>(B_Map.class),mapName);
    }

    /**
     * 坐标的保存到数据库
     *
     * @param bMap
     * @return
     * @throws SQLException
     */
    @Override
    public int insertCoordinate(B_Map bMap) throws SQLException {
        String sql = "insert into map (mapName,coordinate,mapColor) values(?,?,?)";
        return queryRunner.update(sql, bMap.getMapName(), bMap.getCoordinate(), bMap.getMapColor());
    }

    /**
     * 实现查询数据库中的配送范围的区域数
     *
     * @return
     * @throws SQLException
     */
    @Override
    public List<B_Map> group() throws SQLException {
        String sql = "select * from map group by mapName";
        return queryRunner.query(sql, new BeanListHandler<>(B_Map.class));

    }

    /**
     * 分组查询全部配送范围的信息
     *
     * @return
     * @throws SQLException
     */
    @Override
    public List<B_Map> groupData() throws SQLException {
        String sql = "select * from map group by mapName";
        return queryRunner.query(sql, new BeanListHandler<>(B_Map.class));
    }

    /**
     * 删除地图
     *
     * @param mapName
     * @return
     * @throws SQLException
     */
    @Override
    public int deleteMap(String mapName) throws SQLException {
        String sql = "delete from map where mapName=?";
        return queryRunner.update(sql, mapName);
    }

    /**
     * 实现分页 每页记录数为10条
     *
     * @param page
     * @return
     * @throws SQLException
     */
    @Override
    public List<B_Map> mapList(int page) throws SQLException {
        String sql = "select * from map group by mapName limit ?,10 ";
        return queryRunner.query(sql, new BeanListHandler<>(B_Map.class), page);
    }

    /**
     * 修改配送范围坐标
     * @param bMap
     * @return
     * @throws SQLException
     */
    @Override
    public int updateScope(B_Map bMap) throws SQLException {
        String sql = "update map set mapName = ? , coordinate = ? , mapColor = ? where mapName = ?";
        return queryRunner.update(sql, bMap.getMapName(), bMap.getCoordinate(), bMap.getMapColor(), bMap.getMapName());
    }
}
