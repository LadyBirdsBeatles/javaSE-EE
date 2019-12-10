package com.xiaochen.pojo;

import java.util.Date;

public class Car {
    private Integer carId;

    private String carCard;

    private String carExhaust;

    private Integer carPid;

    private Integer carUid;

    private Date carStartdate;

    private Date carEnddate;

    private String carOther1;

    private String carOther2;

    @Override
    public String toString() {
        return "Car{" +
                "carId=" + carId +
                ", carCard='" + carCard + '\'' +
                ", carExhaust='" + carExhaust + '\'' +
                ", carPid=" + carPid +
                ", carUid=" + carUid +
                ", carStartdate=" + carStartdate +
                ", carEnddate=" + carEnddate +
                ", carOther1='" + carOther1 + '\'' +
                ", carOther2='" + carOther2 + '\'' +
                '}';
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public String getCarCard() {
        return carCard;
    }

    public void setCarCard(String carCard) {
        this.carCard = carCard == null ? null : carCard.trim();
    }

    public String getCarExhaust() {
        return carExhaust;
    }

    public void setCarExhaust(String carExhaust) {
        this.carExhaust = carExhaust == null ? null : carExhaust.trim();
    }

    public Integer getCarPid() {
        return carPid;
    }

    public void setCarPid(Integer carPid) {
        this.carPid = carPid;
    }

    public Integer getCarUid() {
        return carUid;
    }

    public void setCarUid(Integer carUid) {
        this.carUid = carUid;
    }

    public Date getCarStartdate() {
        return carStartdate;
    }

    public void setCarStartdate(Date carStartdate) {
        this.carStartdate = carStartdate;
    }

    public Date getCarEnddate() {
        return carEnddate;
    }

    public void setCarEnddate(Date carEnddate) {
        this.carEnddate = carEnddate;
    }

    public String getCarOther1() {
        return carOther1;
    }

    public void setCarOther1(String carOther1) {
        this.carOther1 = carOther1 == null ? null : carOther1.trim();
    }

    public String getCarOther2() {
        return carOther2;
    }

    public void setCarOther2(String carOther2) {
        this.carOther2 = carOther2 == null ? null : carOther2.trim();
    }
}