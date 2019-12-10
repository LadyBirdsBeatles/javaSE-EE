package com.xiaochen.pojo;

import java.io.Serializable;

public class User implements Serializable{
    private Integer userId;

    private String userName;

    private String userPassword;

    private String userPhoneNumber;

    private String userDress;

    private String userSize;

    private Integer userType;

    private Integer userAuth;

    public Integer getUserAuth() {
        return userAuth;
    }

    public void setUserAuth(Integer userAuth) {
        this.userAuth = userAuth;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    public String getUserPhonenumber() {
        return userPhoneNumber;
    }

    public void setUserPhonenumber(String userPhonenumber) {
        this.userPhoneNumber = userPhonenumber == null ? null : userPhonenumber.trim();
    }

    public String getUserDress() {
        return userDress;
    }

    public void setUserDress(String userDress) {
        this.userDress = userDress == null ? null : userDress.trim();
    }

    public String getUserSize() {
        return userSize;
    }

    public void setUserSize(String userSize) {
        this.userSize = userSize == null ? null : userSize.trim();
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userPhonenumber='" + userPhoneNumber + '\'' +
                ", userDress='" + userDress + '\'' +
                ", userSize='" + userSize + '\'' +
                ", userType=" + userType +
                ", userAuth=" + userAuth +
                '}';
    }
}