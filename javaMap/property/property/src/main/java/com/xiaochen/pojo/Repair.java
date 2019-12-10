package com.xiaochen.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


public class Repair implements Serializable{
    private Integer repairId;

    private String repairTitle;

    private Date repairDate;

    private String repairContent;

    private Integer repairState;

    private String repairEva;

    private Admin admin;

    private User user;
    private List<Reply> reply;

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

    public Integer getRepairId() {
        return repairId;
    }

    public void setRepairId(Integer repairId) {
        this.repairId = repairId;
    }


    public String getRepairTitle() {
        return repairTitle;
    }

    public void setRepairTitle(String repairTitle) {
        this.repairTitle = repairTitle == null ? null : repairTitle.trim();
    }

    public Date getRepairDate() {
        return repairDate;
    }

    public void setRepairDate(Date repairDate) {
        this.repairDate = repairDate;
    }

    public String getRepairContent() {
        return repairContent;
    }

    public void setRepairContent(String repairContent) {
        this.repairContent = repairContent == null ? null : repairContent.trim();
    }

    public Integer getRepairState() {
        return repairState;
    }

    public void setRepairState(Integer repairState) {
        this.repairState = repairState;
    }

    public String getRepairEva() {
        return repairEva;
    }

    public void setRepairEva(String repairEva) {
        this.repairEva = repairEva == null ? null : repairEva.trim();
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    @Override
    public String toString() {
        return "Repair{" +
                "repairId=" + repairId +
                ", repairTitle='" + repairTitle + '\'' +
                ", repairDate=" + repairDate +
                ", repairContent='" + repairContent + '\'' +
                ", repairState=" + repairState +
                ", repairEva='" + repairEva + '\'' +
                ", admin=" + admin +
                ", user=" + user +
                ", reply=" + reply +
                '}';
    }
}