package com.itoyokado.cms.entity;

import java.util.Date;

/**
 * 用户表
 */
public class User {
    //主键id
    private Integer id;
    //用户头像
    private String avatar;
    //用户名
    private String name;
    //密码（MD5（明文密码+手机号码））
    private String password;
    //创建日期（毫秒数）
    private Date created_date;
    //上次修改时间（毫秒数）
    private Date last_modified_date;
    //最后登录日期（毫秒数）
    private Date last_login_date;
    //最后登录IP地址
    private String last_login_ip;
    //手机号码
    private String tel;

    public User() {
        this.id = id;
        this.avatar = avatar;
        this.name = name;
        this.password = password;
        this.created_date = created_date;
        this.last_modified_date = last_modified_date;
        this.last_login_date = last_login_date;
        this.last_login_ip = last_login_ip;
        this.tel = tel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }

    public Date getLast_modified_date() {
        return last_modified_date;
    }

    public void setLast_modified_date(Date last_modified_date) {
        this.last_modified_date = last_modified_date;
    }

    public Date getLast_login_date() {
        return last_login_date;
    }

    public void setLast_login_date(Date last_login_date) {
        this.last_login_date = last_login_date;
    }

    public String getLast_login_ip() {
        return last_login_ip;
    }

    public void setLast_login_ip(String last_login_ip) {
        this.last_login_ip = last_login_ip;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
