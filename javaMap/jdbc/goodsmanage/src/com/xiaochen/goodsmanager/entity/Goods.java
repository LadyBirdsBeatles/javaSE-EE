package com.xiaochen.goodsmanager.entity;

import java.io.Serializable;

/**
 * 商品
 */
public class Goods implements Serializable {
    private int gid;// 商品编号
    private String gname;//  商品名称
    private String gprice;//  商品价格

    public Goods() {
    }

    public Goods(int gid, String gname, String gprice) {
        this.gid = gid;
        this.gname = gname;
        this.gprice = gprice;
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public String getGprice() {
        return gprice;
    }

    public void setGprice(String gprice) {
        this.gprice = gprice;
    }

    @Override
    public String toString() {
        return  gid + "\t" + gname + "\t" + gprice ;
    }
}
