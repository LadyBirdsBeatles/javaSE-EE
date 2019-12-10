package com.itoyokado.cms.common;

import com.itoyokado.cms.util.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BaseCRUD{
    /**
     *
     * @param sql sql语句
     * @param params 参数数组
     * @return 返回list集合 装map
     * @throws SQLException
     */
    public List<Map<String,Object>> select(String sql, Object[] params) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());
        List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
        if (params == null){
            list = queryRunner.query(sql, new MapListHandler());
        }else {
            list = queryRunner.query(sql, new MapListHandler(), params);
        }
        return list;
    }

    /**
     * 修改方法
     * @param sql
     * @param params
     * @return
     * @throws SQLException
     */
    public int update(String sql,Object[] params) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());
        int update = queryRunner.update(sql, params);
        return update;
    }

    /**
     *
     * @param sql
     *            插入sql语句
     * @param params
     *            插入参数
     * @return 返回影响行数
     */
    public int insert(String sql, Object[] params) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());
        int affectedRows = 0;
            if (params == null) {
                affectedRows = queryRunner.update(sql);
            } else {
                affectedRows = queryRunner.update(sql, params);
            }
        return affectedRows;
    }
}
