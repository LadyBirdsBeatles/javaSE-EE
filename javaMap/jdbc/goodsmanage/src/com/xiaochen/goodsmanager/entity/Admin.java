package com.xiaochen.goodsmanager.entity;

/**
 * 管理员
 */
public class Admin {
    private int id;//  管理员工id
    private String name;// 姓名
    private String account;// 账号
    private String pwd;// 密码
    private int eage;//  年龄
    private String gender;//  性别
    private String phonenumber;// 电话号码
    private int power;//权限

    public Admin() {
    }

    public Admin(int id, String name, String account, String pwd, int eage, String gender, String phonenumber,int power) {
        this.id = id;
        this.name = name;
        this.account = account;
        this.pwd = pwd;
        this.eage = eage;
        this.gender = gender;
        this.phonenumber = phonenumber;
        this.power=power;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public int getEage() {
        return eage;
    }

    public void setEage(int eage) {
        this.eage = eage;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return   id + "\t" + name + "\t"+ account  + "\t" + pwd  + "\t" + eage +
                "\t" + gender  + "\t" + phonenumber + "\t" + power;
    }
}
