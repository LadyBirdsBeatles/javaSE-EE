package com.xiaochen.pojo;

import java.util.Date;

public class Park {
    private Integer parkId;

    private Integer parkUid;

    private String parkLocal;

    private String parkPrice;

    private Integer parkCid;

    private String name;

    private String card;

    private Date parkSaledate;

    public String getName() {
        return name;
    }

    public Integer getParkCid() {
        return parkCid;
    }

    public void setParkCid(Integer parkCid) {
        this.parkCid = parkCid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public Date getParkSaledate() {
        return parkSaledate;
    }

    public void setParkSaledate(Date parkSaledate) {
        this.parkSaledate = parkSaledate;
    }

    public Integer getParkId() {
        return parkId;
    }

    public void setParkId(Integer parkId) {
        this.parkId = parkId;
    }

    public Integer getParkUid() {
        return parkUid;
    }

    public void setParkUid(Integer parkUid) {
        this.parkUid = parkUid;
    }

    public String getParkLocal() {
        return parkLocal;
    }

    public void setParkLocal(String parkLocal) {
        this.parkLocal = parkLocal == null ? null : parkLocal.trim();
    }

    public String getParkPrice() {
        return parkPrice;
    }

    public void setParkPrice(String parkPrice) {
        this.parkPrice = parkPrice == null ? null : parkPrice.trim();
    }


}