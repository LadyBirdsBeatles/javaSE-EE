package com.itoyokado.cms.entity;

/**
 * 用户权限
 * @author xiaochen
 */
public class User_Authority {
    //主键id
    private Integer id;
    //权限标识
    private String authority_mark;
    //用户id
    private Integer user_id;

    public User_Authority(Integer id, String authority_mark, Integer user_id) {
        this.id = id;
        this.authority_mark = authority_mark;
        this.user_id = user_id;
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

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }
}
