package com.xiaochen.pojo;

public class Admin {
    private Integer adminId;

    private String adminName;

    private String adminPassword;

    private String adminPhoneNumber;

    private String adminPost;

    private Integer adminPower;

    private String adminSalary;

    private String adminDate;

    private Integer adminStatus;

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName == null ? null : adminName.trim();
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword == null ? null : adminPassword.trim();
    }

    public String getAdminPhoneNumber() {
        return adminPhoneNumber;
    }

    public void setAdminPhoneNumber(String adminPhoneNumber) {
        this.adminPhoneNumber = adminPhoneNumber;
    }

    public String getAdminPost() {
        return adminPost;
    }

    public void setAdminPost(String adminPost) {
        this.adminPost = adminPost == null ? null : adminPost.trim();
    }

    public Integer getAdminPower() {
        return adminPower;
    }

    public void setAdminPower(Integer adminPower) {
        this.adminPower = adminPower == null ? null : adminPower;
    }

    public String getAdminSalary() {
        return adminSalary;
    }

    public void setAdminSalary(String adminSalary) {
        this.adminSalary = adminSalary == null ? null : adminSalary.trim();
    }

    public String getAdminDate() {
        return adminDate;
    }

    public void setAdminDate(String adminDate) {
        this.adminDate = adminDate;
    }

    public Integer getAdminStatus() {
        return adminStatus;
    }

    public void setAdminStatus(Integer adminStatus) {
        this.adminStatus = adminStatus;
    }


    @Override
    public String toString() {
        return "Admin{" +
                "adminId=" + adminId +
                ", adminName='" + adminName + '\'' +
                ", adminPassword='" + adminPassword + '\'' +
                ", adminPhoneNumber=" + adminPhoneNumber +
                ", adminPost='" + adminPost + '\'' +
                ", adminPower='" + adminPower + '\'' +
                ", adminSalary='" + adminSalary + '\'' +
                ", adminDate='" + adminDate + '\'' +
                ", adminStatus=" + adminStatus +
                '}';
    }
}