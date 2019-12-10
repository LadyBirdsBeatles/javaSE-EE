package com.itoyokado.cms.dao;

import com.itoyokado.cms.entity.Sys_User;

import java.sql.SQLException;
import java.util.List;

public interface SysUserDao {
    /**
     *  添加系统用户
     * @param sys_user
     * @return
     */
    int addUser(Sys_User sys_user) throws SQLException;

    /**
     *  sys_user登陆验证
     * @param sys_user
     * @return
     * @throws SQLException
     */
    Sys_User loginSysUser (Sys_User sys_user) throws SQLException;

    /**
     * 更新用户信息
     * @param sys_user
     * @return
     * @throws SQLException
     */
    Boolean updateMsg(Sys_User sys_user) throws SQLException;

    /**
     * 查询工号最大值,生成新的工号
     * @return
     * @throws SQLException
     */
    String findjobNumMax() throws SQLException;

    /**
     * 查询所有
     * @return
     * @throws SQLException
     */
    int findSysUserCount() throws SQLException;

    List<Sys_User> findSysUserByPageAndlimit(int page, int limit) throws SQLException;

    int updateSysPowerAndPassowrdById(int type, String s_password, int id) throws SQLException;

    /**
     * 通过工号或者姓名查询
     * @param job_number
     * @param field
     * @return
     */
    List<Sys_User> findUserByFiled(String param, String field) throws SQLException;

    int updateSysPower(int type,int id) throws SQLException;
}
