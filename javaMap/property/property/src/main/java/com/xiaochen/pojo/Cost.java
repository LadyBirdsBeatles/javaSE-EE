package com.xiaochen.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class Cost implements Serializable{
    private Integer costId;

    private String costWater;

    private String costGas;

    private String costPower;

    private String costAir;

    private String costOther;

    private Date costDate;

    private Integer costState;

    private User user;

    public Integer getCostId() {
        return costId;
    }

    public void setCostId(Integer costId) {
        this.costId = costId;
    }

    public String getCostWater() {
        return costWater;
    }

    public void setCostWater(String costWater) {
        this.costWater = costWater == null ? null : costWater.trim();
    }

    public String getCostGas() {
        return costGas;
    }

    public void setCostGas(String costGas) {
        this.costGas = costGas == null ? null : costGas.trim();
    }

    public String getCostPower() {
        return costPower;
    }

    public void setCostPower(String costPower) {
        this.costPower = costPower == null ? null : costPower.trim();
    }

    public String getCostAir() {
        return costAir;
    }

    public void setCostAir(String costAir) {
        this.costAir = costAir == null ? null : costAir.trim();
    }

    public String getCostOther() {
        return costOther;
    }

    public void setCostOther(String costOther) {
        this.costOther = costOther == null ? null : costOther.trim();
    }

    public Date getCostDate() { return costDate; }

    @DateTimeFormat(pattern = "yyyy-MM")
    public void setCostDate(Date costDate) {
        this.costDate = costDate;
    }

    public Integer getCostState() {
        return costState;
    }

    public void setCostState(Integer costState) {
        this.costState = costState;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Cost{" +
                "costId=" + costId +
                ", costWater='" + costWater + '\'' +
                ", costGas='" + costGas + '\'' +
                ", costPower='" + costPower + '\'' +
                ", costAir='" + costAir + '\'' +
                ", costOther='" + costOther + '\'' +
                ", costDate=" + costDate +
                ", costState=" + costState +
                ", user=" + user +
                '}';
    }
}