package com.xiaochen.goodsmanager.entity;

import java.io.Serializable;

/**
 * 库存
 */
public class Repertory implements Serializable {
    private int rid;// id 主键
    private int gid;// 商品id
    private int snumber;//总量
    private int routnumber;// 售出
    private int residue;// 剩余
    private String rdata;// 售出日期
    private String ecomment;// 备注

    public Repertory() {
    }

    public Repertory(int rid, int gid, int snumber, int routnumber, int residue, String rdata, String ecomment) {
        this.rid = rid;
        this.gid = gid;
        this.snumber = snumber;
        this.routnumber = routnumber;
        this.residue = residue;
        this.rdata = rdata;
        this.ecomment = ecomment;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public int getSnumber() {
        return snumber;
    }

    public void setSnumber(int snumber) {
        this.snumber = snumber;
    }

    public int getRoutnumber() {
        return routnumber;
    }

    public void setRoutnumber(int routnumber) {
        this.routnumber = routnumber;
    }

    public int getResidue() {
        return residue;
    }

    public void setResidue(int residue) {
        this.residue = residue;
    }

    public String getRdata() {
        return rdata;
    }

    public void setRdata(String rdata) {
        this.rdata = rdata;
    }

    public String getEcomment() {
        return ecomment;
    }

    public void setEcomment(String ecomment) {
        this.ecomment = ecomment;
    }

    @Override
    public String toString() {
        return  rid +
                "\t" + gid +
                "\t" + snumber +
                "\t" + routnumber +
                "\t" + residue +
                "\t" + rdata +
                "\t"+ ecomment
               ;
    }
}
