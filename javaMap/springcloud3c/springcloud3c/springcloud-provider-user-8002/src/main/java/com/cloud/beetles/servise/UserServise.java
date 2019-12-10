package com.cloud.beetles.servise;

import com.cloud.beetles.pojo.Users;

import java.util.List;


public interface UserServise {
    public boolean adduser(String user);

    public Users queryuserid(long id);

    public List queryuser();
}
