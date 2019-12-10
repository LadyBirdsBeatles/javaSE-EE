package com.xiaochen.service;

import com.xiaochen.pojo.Access;

import java.util.List;
import java.util.Map;

public interface AccessService {

    int insertAccess(Access access);

    int updateAccess(Access access);

    List<Access> selectAccessList(Map maps);

    List<Access> selectAccess(Access access);
}
