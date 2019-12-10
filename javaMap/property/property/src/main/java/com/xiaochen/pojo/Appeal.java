package com.xiaochen.pojo;

import java.util.Date;
import java.util.List;

public class Appeal {
    private Integer appealId;

    private String appealTitle;

    private Date appealDate;

    private String appealContent;

    private Integer appealState;

    private String appealEva;

    private Admin admin;

    private User user;
    private List<Reply> reply;
    public Integer getAppealId() {
        return appealId;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Reply> getReply() {
        return reply;
    }

    public void setReply(List<Reply> reply) {
        this.reply = reply;
    }

    public void setAppealId(Integer appealId) {
        this.appealId = appealId;
    }

    public String getAppealTitle() {
        return appealTitle;
    }

    public void setAppealTitle(String appealTitle) {
        this.appealTitle = appealTitle == null ? null : appealTitle.trim();
    }

    public Date getAppealDate() {
        return appealDate;
    }

    public void setAppealDate(Date appealDate) {
        this.appealDate = appealDate;
    }

    public String getAppealContent() {
        return appealContent;
    }

    public void setAppealContent(String appealContent) {
        this.appealContent = appealContent == null ? null : appealContent.trim();
    }

    public Integer getAppealState() {
        return appealState;
    }

    public void setAppealState(Integer appealState) {
        this.appealState = appealState;
    }


    public String getAppealEva() {
        return appealEva;
    }

    public void setAppealEva(String appealEva) {
        this.appealEva = appealEva == null ? null : appealEva.trim();
    }

    @Override
    public String toString() {
        return "Appeal{" +
                "appealId=" + appealId +
                ", appealTitle='" + appealTitle + '\'' +
                ", appealDate=" + appealDate +
                ", appealContent='" + appealContent + '\'' +
                ", appealState=" + appealState +
                ", appealEva='" + appealEva + '\'' +
                ", admin=" + admin +
                ", user=" + user +
                ", reply=" + reply +
                '}';
    }
}