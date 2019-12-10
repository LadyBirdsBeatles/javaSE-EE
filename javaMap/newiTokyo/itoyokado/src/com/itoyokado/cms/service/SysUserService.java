package com.itoyokado.cms.service;

import com.itoyokado.cms.entity.PageBean;
import com.itoyokado.cms.entity.Sys_User;

import java.sql.SQLException;
import java.util.List;

public interface SysUserService {
    Boolean addUser(Sys_User sys_user) throws SQLException;

    PageBean findUserBypageAndlimit(int page, int limit) throws SQLException;

    List<Sys_User> findUserByField(String param, String field) throws SQLException;

    int updateSysPowerAndPasswordById(int type, String s_password, int id) throws SQLException;

    int updateSysPower(int type, int id) throws SQLException;

    Sys_User loginSysUser(Sys_User sys_user) throws SQLException;

    Boolean updateMsg(Sys_User sys_user) throws SQLException;

}
