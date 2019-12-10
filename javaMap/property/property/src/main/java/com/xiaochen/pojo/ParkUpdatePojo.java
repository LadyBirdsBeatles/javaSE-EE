package com.xiaochen.pojo;


public class ParkUpdatePojo {
    private String carCard;
    private Integer parkId;
    private String parkLocal;
    private String parkPrice;
    private String userName;
    private String userPhonenumber;


    @Override
    public String toString() {
        return "ParkUpdatePojo{" +
                "carCard='" + carCard + '\'' +
                ", parkId=" + parkId +
                ", parkLocal='" + parkLocal + '\'' +
                ", parkPrice='" + parkPrice + '\'' +
                ", userName='" + userName + '\'' +
                ", userPhonenumber='" + userPhonenumber + '\'' +
                '}';
    }

    public String getCarCard() {
        return carCard;
    }

    public void setCarCard(String carCard) {
        this.carCard = carCard;
    }

    public Integer getParkId() {
        return parkId;
    }

    public void setParkId(Integer parkId) {
        this.parkId = parkId;
    }

    public String getParkLocal() {
        return parkLocal;
    }

    public void setParkLocal(String parkLocal) {
        this.parkLocal = parkLocal;
    }

    public String getParkPrice() {
        return parkPrice;
    }

    public void setParkPrice(String parkPrice) {
        this.parkPrice = parkPrice;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhonenumber() {
        return userPhonenumber;
    }

    public void setUserPhonenumber(String userPhonenumber) {
        this.userPhonenumber = userPhonenumber;
    }
}
