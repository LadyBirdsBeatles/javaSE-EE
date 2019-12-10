package com.itoyokado.cms.entity;

/**
 * 系统用户权限
 */
public class Sys_User_Authority {
    //主键id
    private Integer id;
    //权限标识
    private String authority_mark;
    //系统用户id
    private Integer sys_user_id;

    public Sys_User_Authority(Integer id, String authority_mark, Integer sys_user_id) {
        this.id = id;
        this.authority_mark = authority_mark;
        this.sys_user_id = sys_user_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthority_mark() {
        return authority_mark;
    }

    public void setAuthority_mark(String authority_mark) {
        this.authority_mark = authority_mark;
    }

    public Integer getSys_user_id() {
        return sys_user_id;
    }

    public void setSys_user_id(Integer sys_user_id) {
        this.sys_user_id = sys_user_id;
    }
}
