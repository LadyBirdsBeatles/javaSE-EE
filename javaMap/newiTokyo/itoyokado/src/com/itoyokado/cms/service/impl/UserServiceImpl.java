package com.itoyokado.cms.service.impl;

import com.itoyokado.cms.dao.UserDao;
import com.itoyokado.cms.dao.impl.UserDaoImpl;
import com.itoyokado.cms.entity.User;
import com.itoyokado.cms.service.UserService;

public class UserServiceImpl implements UserService {

    @Override
    public Boolean Login(User user) throws Exception {
        UserDao userDao = new UserDaoImpl();
        Boolean Loginresoult = userDao.validateUser(user);
        if (Loginresoult){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Integer findUserByPhone(String phone) throws Exception {
        UserDao userDao = new UserDaoImpl();
        Integer userPhone = userDao.findUserByPhone(phone);
        return userPhone;
    }

    @Override
    public void LoginUpdate(User user) throws Exception {
        UserDao userDao = new UserDaoImpl();
        userDao.LoginUpdate(user);
    }
}
