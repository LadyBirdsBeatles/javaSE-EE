package com.itoyokado.cms.dao.impl;

import com.itoyokado.cms.common.BaseCRUD;
import com.itoyokado.cms.dao.UserDao;
import com.itoyokado.cms.entity.User;
import com.itoyokado.cms.util.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;

public class UserDaoImpl implements UserDao {
    QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
    BaseCRUD baseCRUD = new BaseCRUD();
    @Override
    public Boolean validateUser(User user) throws Exception {
        String name = user.getName();
        String pwd = user.getPassword();
        System.out.println("传进来的:" + name+"密码:"+pwd);
        String sql = " select * from user where name = ? ";
        ResultSetHandler<User> rsh = new BeanHandler<User>(User.class);
        User userFind = runner.query(sql, rsh, name);
        String password = userFind.getPassword();
        System.out.println("查出来的信息:" + password);

        if (pwd.equals(password)) {
            return true;
        } else {
            return false;
        }
    }
    @Override
    public Integer findUserByPhone(String phone) throws Exception {
        String sql = "select * from user where tel=?";
        ResultSetHandler<User> rsh = new BeanHandler<User>(User.class);
        System.out.println("传进来的电话:" + phone);
        User user = runner.query(sql, rsh, phone);
        return user.getId();
    }
    //每次登陆后,自动写入登陆ip地址和登陆时间
    @Override
    public void LoginUpdate(User user) throws Exception {
        String sql = "update user set last_login_date=?,last_login_ip=? where name = ? ";
        runner.update(sql, user.getLast_login_date(),user.getLast_login_ip(),user.getName());
    }
}
