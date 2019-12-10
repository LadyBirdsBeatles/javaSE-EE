package com.xiaochen.goodsmanager.entity;

import java.io.Serializable;

/**
 * 商品详情
 */
public class Particulars implements Serializable {
    private int pid;// id 编号
    private int gid;//
    private int pweight;//  重量
    private String pmanufacture;//  生产日期
    private int pexpiration;//  保质期
    private String ptype;//  类型
    private String psuppliername;//  供应商名称
    private String paddress;//  供应商地址
    private String phonenumber;//  厂商电话
    private String ecomment;//  备注

    public Particulars() {
    }

    public Particulars(int pid, int gid, int pweight, String pmanufacture, int pexpiration, String ptype, String psuppliername, String paddress, String phonenumber, String ecomment) {
        this.pid = pid;
        this.gid = gid;
        this.pweight = pweight;
        this.pmanufacture = pmanufacture;
        this.pexpiration = pexpiration;
        this.ptype = ptype;
        this.psuppliername = psuppliername;
        this.paddress = paddress;
        this.phonenumber = phonenumber;
        this.ecomment = ecomment;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public int getPweight() {
        return pweight;
    }

    public void setPweight(int pweight) {
        this.pweight = pweight;
    }

    public String getPmanufacture() {
        return pmanufacture;
    }

    public void setPmanufacture(String pmanufacture) {
        this.pmanufacture = pmanufacture;
    }

    public int getPexpiration() {
        return pexpiration;
    }

    public void setPexpiration(int pexpiration) {
        this.pexpiration = pexpiration;
    }

    public String getPtype() {
        return ptype;
    }

    public void setPtype(String ptype) {
        this.ptype = ptype;
    }

    public String getPsuppliername() {
        return psuppliername;
    }

    public void setPsuppliername(String psuppliername) {
        this.psuppliername = psuppliername;
    }

    public String getPaddress() {
        return paddress;
    }

    public void setPaddress(String paddress) {
        this.paddress = paddress;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getEcomment() {
        return ecomment;
    }

    public void setEcomment(String ecomment) {
        this.ecomment = ecomment;
    }

    @Override
    public String toString() {
        return pid +
                "\t" + gid +
                "\t" + pweight +
                "\t" + pmanufacture +
                "\t" + pexpiration +
                "\t" + ptype +
                "\t" + psuppliername +
                "\t" + paddress +
                "\t" + phonenumber +
                "\t" + ecomment;
    }
}
