package com.itoyokado.cms.dao.impl;

import com.itoyokado.cms.dao.SysUserDao;
import com.itoyokado.cms.entity.Sys_User;
import com.itoyokado.cms.util.JDBCUtil;
import com.itoyokado.cms.util.MD5Creater;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class SysUserDaoImpl implements SysUserDao {
    QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());

    @Override
    public int addUser(Sys_User sys_user) throws SQLException {
        String sql = "insert into sys_user values(null,?,null,?,md5(?),?,null,null,null,null,?,?,?,?)";
        SysUserDaoImpl sysUserDao = new SysUserDaoImpl();
        String job_number = sysUserDao.findjobNumMax();
        QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
//        df.format(new Date();// new Date()为获取当前系统时间

        int update = queryRunner.update(sql, job_number, sys_user.getS_name(), sys_user.getS_password(), new Date(), sys_user.getS_tel(), sys_user.getCompany_id(), sys_user.getType(), sys_user.getId_card());
//        queryRunner.update();
        return update;
    }

    @Override
    public Sys_User loginSysUser(Sys_User sys_user) throws SQLException {
        String s_name = sys_user.getS_name();
        String s_password = sys_user.getS_password();
        String sql = " select * from sys_user where s_name = ? or job_number = ? or s_tel = ? and s_password = ?";
        ResultSetHandler<Sys_User> rsh = new BeanHandler<Sys_User>(Sys_User.class);
        Sys_User sys_userFind = runner.query(sql, rsh, s_name,s_name,s_name,s_password);
        System.out.println(sys_user.toString());

        if (Objects.isNull(sys_userFind)) {
            return null;
        }


        return sys_userFind;


    }

    @Override
    public Boolean updateMsg(Sys_User sys_user) throws SQLException {
        String sql = "update sys_user set last_login_date=?,last_login_ip=? where s_name = ? ";
        int update = runner.update(sql, sys_user.getLast_login_date(), sys_user.getLast_login_ip(), sys_user.getS_name());
        if (update == 1) {
            System.out.println("更新信息成功!");
            return true;
        } else {
            return false;
        }
    }

    /**
     * 生成员工编号方法
     *
     * @return
     * @throws SQLException
     */
    @Override
    public String findjobNumMax() throws SQLException {
        String sql = "select IFNULL(max(substr(job_number, 3,LENGTH(job_number))+1), -1) FROM  sys_user";
        QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());
        double query = queryRunner.query(sql, new ScalarHandler<Double>());
        String jobNum = "KF" + (int) query;
        return jobNum;
    }

    /**
     * 查询系统用户表总记录数,去除掉超级管理员
     *
     * @return
     * @throws SQLException
     */
    @Override
    public int findSysUserCount() throws SQLException {
        String sql = "select count(*) from sys_user where type >-1";
        QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());
        Long count = (Long) queryRunner.query(sql, new ScalarHandler<>());
        return count.intValue();
    }

    /**
     * 查询指定页数的系统用户数据
     *
     * @param page
     * @param limit
     * @return
     */
    @Override
    public List<Sys_User> findSysUserByPageAndlimit(int page, int limit) throws SQLException {
        String sql = "select * from sys_user where type > -1 ORDER BY id DESC limit ?,?";
        QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());
        List<Sys_User> query = queryRunner.query(sql, new BeanListHandler<Sys_User>(Sys_User.class), (page - 1) * limit, limit);
        return query;
    }

    @Override
    public int updateSysPowerAndPassowrdById(int type, String s_password, int id) throws SQLException {
        String password = MD5Creater.getMD5(s_password);
        String sql = "update sys_user set type=?,s_password=?,last_modified_date=? where id=?";
        QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());
        int update = queryRunner.update(sql, type, password, new Date(), id);
        return update;
    }

    @Override
    public List<Sys_User> findUserByFiled(String param, String field) throws SQLException {
        String sql = "select * from sys_user where " + param + "='" + field + "'";
        QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());
        return queryRunner.query(sql, new BeanListHandler<Sys_User>(Sys_User.class));
    }

    @Override
    public int updateSysPower(int type, int id) throws SQLException {
        String sql = "update sys_user set type=?,last_modified_date=? where id=?";
        QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());
        int update = queryRunner.update(sql, type, new Date(), id);
        return update;
    }

}
