package com.itoyokado.cms.service;

import com.itoyokado.cms.entity.B_Map;

import java.sql.SQLException;
import java.util.List;

/**
 * mapService接口
 */
public interface mapService {
    /**
     * 获取所有配送范围
     *
     * @return
     */
    List<B_Map> selectAll() throws SQLException, ClassNotFoundException;

    /**
     * 获取指定配送范围
     *
     * @param mapName
     * @return
     */
    List<B_Map> selectCoordinate(String mapName) throws SQLException;

    /**
     * 添加坐标
     *
     * @param bMap
     * @return
     */
    int insertCoord(B_Map bMap) throws SQLException;

    /**
     * 分组查询范围个数
     *
     * @return
     */
    List<B_Map> group() throws SQLException;

    /**
     * 分组查询范围个数
     *
     * @return
     */
    List<B_Map> groupData() throws SQLException;

    /**
     * 删除地图
     *
     * @param mapName
     * @return
     */
    int deleteMap(String mapName) throws SQLException;

    /**
     * 分页显示
     *
     * @param page
     * @return
     */
    List<B_Map> bList(int page) throws SQLException;

    /**
     * 修改配送范围的坐标
     *
     * @param B_Map
     * @return
     */
    int updateScope(B_Map bMap) throws SQLException;
}
