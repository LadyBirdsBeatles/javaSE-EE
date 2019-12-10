package com.xiaochen.goodsmanager.entity;

import java.io.Serializable;
import java.sql.Date;

/**
 * 员工
 */
public class Employee implements Serializable {
    private int eid;  //员工id主键
    private String ename;// 员工姓名
    private String egender;// 性别
    private int eage;// 年龄
    private String ebirthday;// 生日
    private String department;// 部门
    private String ejob;// 职务
    private String ephonenumber;// 电话号码
    private String ehiredate;//入职时间
    private String ecomment;// 备注


    public Employee() {

    }

    public Employee(int eid, String ename, String egender, int eage, String ebirthday, String department, String ejob, String ephonenumber, String ehiredate, String ecomment) {
        this.eid = eid;
        this.ename = ename;
        this.egender = egender;
        this.eage = eage;
        this.ebirthday = ebirthday;
        this.department = department;
        this.ejob = ejob;
        this.ephonenumber = ephonenumber;
        this.ehiredate = ehiredate;
        this.ecomment = ecomment;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getEgender() {
        return egender;
    }

    public void setEgender(String egender) {
        this.egender = egender;
    }

    public int getEage() {
        return eage;
    }

    public void setEage(int eage) {
        this.eage = eage;
    }

    public String getEbirthday() {
        return ebirthday;
    }

    public void setEbirthday(String ebirthday) {
        this.ebirthday = ebirthday;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEjob() {
        return ejob;
    }

    public void setEjob(String ejob) {
        this.ejob = ejob;
    }

    public String getEphonenumber() {
        return ephonenumber;
    }

    public void setEphonenumber(String ephonenumber) {
        this.ephonenumber = ephonenumber;
    }

    public String getEcomment() {
        return ecomment;
    }

    public void setEcomment(String ecomment) {
        this.ecomment = ecomment;
    }

    public String getEhiredate() {
        return ehiredate;
    }

    public void setEhiredate(String ehiredate) {
        this.ehiredate = ehiredate;
    }

    @Override
    public String toString() {
        return eid + "\t" + ename  +"\t" + egender  + "\t" + eage + "\t" + ebirthday  + "\t" + department  + "\t" + ejob  + "\t" + ephonenumber + "\t" + ehiredate  + "\t" + ecomment ;

    }
}
