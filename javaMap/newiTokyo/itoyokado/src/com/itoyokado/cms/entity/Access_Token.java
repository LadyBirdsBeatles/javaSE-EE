package com.itoyokado.cms.entity;

import java.util.Date;

/**
 *手持端授权码
 */
public class Access_Token {
    //授权码id
    private Integer id;
    //授权码
    private String token;
    //过期时间(毫秒数)
    private Date expiration;
    //系统用户ID
    private Integer sys_user_id;

    public Access_Token(Integer id, String token, Date expiration, Integer sys_user_id) {
        this.id = id;
        this.token = token;
        this.expiration = expiration;
        this.sys_user_id = sys_user_id;
    }

    @Override
    public String toString() {
        return "Access_Token{" +
                "id=" + id +
                ", token='" + token + '\'' +
                ", expiration=" + expiration +
                ", sys_user_id=" + sys_user_id +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getExpiration() {
        return expiration;
    }

    public void setExpiration(Date expiration) {
        this.expiration = expiration;
    }

    public Integer getSys_user_id() {
        return sys_user_id;
    }

    public void setSys_user_id(Integer sys_user_id) {
        this.sys_user_id = sys_user_id;
    }
}
