package com.itoyokado.cms.service.impl;

import com.itoyokado.cms.dao.impl.mapDaoImpl;
import com.itoyokado.cms.dao.mapDao;
import com.itoyokado.cms.entity.B_Map;
import com.itoyokado.cms.service.mapService;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class mapServiceImpl implements mapService {
    mapDao mapDao = new mapDaoImpl();

    /**
     * 实现所有配送范围
     *
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    @Override
    public List<B_Map> selectAll() throws SQLException, ClassNotFoundException {
        return mapDao.selectAll();
    }

    /**
     * 实现查找指定的配送范围
     *
     * @param mapName
     * @return
     * @throws SQLException
     */
    @Override
    public List<B_Map> selectCoordinate(String mapName) throws SQLException {
        return mapDao.selectCoordinate(mapName);
    }

    /**
     * 实现坐标的添加
     *
     * @param bMap
     * @return
     * @throws SQLException
     */
    @Override
    public int insertCoord(B_Map bMap) throws SQLException {
        return mapDao.insertCoordinate(bMap);
    }

    /**
     * 分组查询配送范围的名字
     *
     * @return
     * @throws SQLException
     */
    @Override
    public List<B_Map> group() throws SQLException {
        return mapDao.group();
    }

    /**
     * 分组查询配送范围的全部信息
     *
     * @return
     * @throws SQLException
     */
    @Override
    public List<B_Map> groupData() throws SQLException {
        return mapDao.groupData();
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
        return mapDao.deleteMap(mapName);
    }

    /**
     * 实现分页
     *
     * @param page
     * @return
     * @throws SQLException
     */
    @Override
    public List<B_Map> bList(int page) throws SQLException {
        return mapDao.mapList(page);
    }

    /**
     * 修改配送范围的坐标
     *
     * @param bMap
     * @return
     * @throws SQLException
     */
    @Override
    public int updateScope(B_Map bMap) throws SQLException {
        return mapDao.updateScope(bMap);
    }

}
