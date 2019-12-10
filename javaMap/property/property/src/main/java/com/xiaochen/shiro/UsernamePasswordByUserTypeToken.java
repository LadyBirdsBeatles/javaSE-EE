package com.xiaochen.shiro;


import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * 自定义带用户类型token
 * @author Sparrow
 */
public class UsernamePasswordByUserTypeToken extends UsernamePasswordToken {
    private static final long serialVersionUID = -7638434498222500528L;

    /*
     * 用户类型
     * 1:后台管理员
     * 2:前台用户
     */
    private String userType;

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public UsernamePasswordByUserTypeToken(String username, String password, String userType) {
        super(username, password);
        this.userType = userType;
    }
}