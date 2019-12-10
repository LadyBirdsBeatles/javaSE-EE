package com.xiaochen.goodsmanager.service.GoodsServiceDaoimpl;

import com.xiaochen.goodsmanager.dao.CommonDao;
import com.xiaochen.goodsmanager.dao.GoodsDaoimpl.CommonDaoimpl;
import com.xiaochen.goodsmanager.dao.GoodsDaoimpl.Logindaoimpl;
import com.xiaochen.goodsmanager.dao.Logindao;
import com.xiaochen.goodsmanager.entity.Admin;
import com.xiaochen.goodsmanager.entity.Employee;
import com.xiaochen.goodsmanager.service.ManageServiceDao;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

public class ManageServiceDaoimpl implements ManageServiceDao {
    private CommonDao commonDao = new CommonDaoimpl();
    private Logindao logindao=new Logindaoimpl();

    /**
     * admin登陆
     *
     * @param admin
     * @return
     */
    @Override
    public int adminlogin(Admin admin) throws SQLException, ClassNotFoundException {
        String account = admin.getAccount();
        String pwd = admin.getPwd();
        Admin adminlogin = logindao.adminlogin(admin);
        if (adminlogin != null) {
            if (account.equals(adminlogin.getAccount())) {
                if (pwd.equals(adminlogin.getPwd())) {
                    return adminlogin.getPower();
                }
            }
        }
        return 0;
    }

    @Override
    public boolean empadd(Employee employee) throws IllegalAccessException, SQLException, ClassNotFoundException {
        return commonDao.insert(employee);
    }

    @Override
    public boolean empdel(Employee employee, Integer id) throws IllegalAccessException, SQLException, ClassNotFoundException {
        return commonDao.delete(employee, id);
    }

    @Override
    public boolean empupdate(Employee employee, Integer id) throws IllegalAccessException, SQLException, ClassNotFoundException {
        return commonDao.update(employee, id);
    }

    @Override
    public List empshows(Employee employee) throws ClassNotFoundException, SQLException, InvocationTargetException, InstantiationException, IllegalAccessException {
        return commonDao.selects(employee);
    }

    @Override
    public List empshow(Employee employee, Integer id) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException, InvocationTargetException {
       return commonDao.select(employee, id);
    }
}
