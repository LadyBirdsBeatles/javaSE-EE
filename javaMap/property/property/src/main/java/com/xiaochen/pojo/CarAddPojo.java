package com.xiaochen.pojo;

import java.util.Date;

public class CarAddPojo {
    private String userName;
    private String userPhone;
    private String carCard;
    private Date carStartdate;
    private Date carEnddate;
    private Integer carPid;

    @Override
    public String toString() {
        return "CarAddPojo{" +
                "userName='" + userName + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", carCard='" + carCard + '\'' +
                ", carStartdate=" + carStartdate +
                ", carEnddate=" + carEnddate +
                ", carPid=" + carPid +
                '}';
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getCarCard() {
        return carCard;
    }

    public void setCarCard(String carCard) {
        this.carCard = carCard;
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

    public Integer getCarPid() {
        return carPid;
    }

    public void setCarPid(Integer carPid) {
        this.carPid = carPid;
    }
}
