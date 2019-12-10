package com.itoyokado.cms.dao;


import com.itoyokado.cms.entity.B_Map;

import java.sql.SQLException;
import java.util.List;

/**
 * mapDao层
 */
public interface mapDao {
    /**
     * 获取所有配送范围
     *
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    List<B_Map> selectAll() throws SQLException, ClassNotFoundException;

    /**
     * 获取指定配送范围
     *
     * @param mapName
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    List<B_Map> selectCoordinate(String mapName) throws SQLException;

    /**
     * 添加坐标
     *
     * @param bMap
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    int insertCoordinate(B_Map bMap) throws SQLException;

    /**
     * 分组查询范围个数
     *
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    List<B_Map> group() throws SQLException;

    /**
     * 分组查询范围个数
     *
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    List<B_Map> groupData() throws SQLException;

    /**
     * 删除数据
     *
     * @param mapName
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    int deleteMap(String mapName) throws SQLException;

    /**
     * 分页查询
     *
     * @param page
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    List<B_Map> mapList(int page) throws SQLException;

    /**
     * 修改配送范围坐标
     *
     * @param B_Map
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    int updateScope(B_Map bMap) throws SQLException;
}
