package com.itoyokado.cms.service.impl;

import com.itoyokado.cms.dao.SysUserDao;
import com.itoyokado.cms.dao.impl.SysUserDaoImpl;
import com.itoyokado.cms.entity.PageBean;
import com.itoyokado.cms.entity.Sys_User;
import com.itoyokado.cms.service.SysUserService;
import com.itoyokado.cms.util.RegexUtil;

import java.sql.SQLException;
import java.util.List;

public class SysUserServiceImpl implements SysUserService {
    @Override
    public Boolean addUser(Sys_User sys_user) throws SQLException {
        SysUserDao sysUserDao = new SysUserDaoImpl();
        //获取工号中的最大值
        int addUser = sysUserDao.addUser(sys_user);
        if (addUser > 0) {
            return true;
        }
        return false;
    }

    @Override
    public PageBean findUserBypageAndlimit(int page, int limit) throws SQLException {
        //封装分页类数据
        PageBean<Sys_User> pageBean = new PageBean<>();
        pageBean.setCurrentPage(page);  //设置当前页
        pageBean.setPageSize(limit);         //设置每页显示多少记录

        SysUserDao sysUserDao = new SysUserDaoImpl();
        int count = sysUserDao.findSysUserCount();
        pageBean.setTotalSize(count);   //设置总记录数
        List<Sys_User> list = sysUserDao.findSysUserByPageAndlimit(page, limit);
        pageBean.setList(list);         //设置当前页数据
        pageBean.setTotalPage(count % limit == 0 ? count / limit : count / limit + 1);        //设置总页数
        return pageBean;
    }


    @Override
    public List<Sys_User> findUserByField(String param, String field) throws SQLException {
        SysUserDao sysUserDao = new SysUserDaoImpl();
        return sysUserDao.findUserByFiled(param, field);
    }

    @Override
    public int updateSysPowerAndPasswordById(int type, String s_password, int id) throws SQLException {
        SysUserDao sysUserDao = new SysUserDaoImpl();
        return sysUserDao.updateSysPowerAndPassowrdById(type, s_password, id);
    }

    @Override
    public int updateSysPower(int type, int id) throws SQLException {
        SysUserDao sysUserDao = new SysUserDaoImpl();
        return sysUserDao.updateSysPower(type, id);
    }

    @Override
    public Sys_User loginSysUser(Sys_User sys_user) throws SQLException {
        SysUserDao sysUserDao = new SysUserDaoImpl();
        return sysUserDao.loginSysUser(sys_user);

    }

    @Override
    public Boolean updateMsg(Sys_User sys_user) throws SQLException {
        SysUserDao sysUserDao = new SysUserDaoImpl();
        return sysUserDao.updateMsg(sys_user);

    }
}
