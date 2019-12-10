package com.itoyokado.cms.service;

import com.itoyokado.cms.entity.User;

public interface UserService {
   Boolean Login(User user)throws Exception;
   public Integer findUserByPhone(String phone) throws Exception;
   public void LoginUpdate(User user)throws  Exception;
}
