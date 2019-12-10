package com.itoyokado.cms.test;

import com.itoyokado.cms.util.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import java.sql.SQLException;

public class SysTest {
    @Test
    public void Test1(){
        String sql = "select IFNULL(max(substr(job_number, 3,LENGTH(job_number))+1), -1) FROM  sys_user";
        QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());
        double query = 0;
        try {
            query = queryRunner.query(sql, new ScalarHandler<Double>());
            String string = "KF"+(int)query;
            System.out.println(string);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(query);
    }
}
