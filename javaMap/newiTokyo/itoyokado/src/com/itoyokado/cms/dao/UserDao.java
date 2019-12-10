package com.itoyokado.cms.dao;

import com.itoyokado.cms.entity.User;

public interface UserDao {
    public Boolean validateUser(User user) throws Exception;
    public Integer findUserByPhone(String phone) throws Exception;
    public void LoginUpdate(User user)throws  Exception;
}
