package com.xiaochen.pojo;

import java.io.Serializable;
import java.util.Date;

public class Reply implements Serializable{
    private Integer replyId;

    private String replyContent;

    private Date replyDate;

    private Integer replyAppid;

    private Integer replyPerson;

    private Integer replyType;

    public Integer getReplyId() {
        return replyId;
    }

    public void setReplyId(Integer replyId) {
        this.replyId = replyId;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent == null ? null : replyContent.trim();
    }

    public Date getReplyDate() {
        return replyDate;
    }

    public void setReplyDate(Date replyDate) {
        this.replyDate = replyDate;
    }

    public Integer getReplyAppid() {
        return replyAppid;
    }

    public void setReplyAppid(Integer replyAppid) {
        this.replyAppid = replyAppid;
    }

    public Integer getReplyPerson() {
        return replyPerson;
    }

    public void setReplyPerson(Integer replyPerson) {
        this.replyPerson = replyPerson;
    }

    public Integer getReplyType() {
        return replyType;
    }

    public void setReplyType(Integer replyType) {
        this.replyType = replyType;
    }

    @Override
    public String toString() {
        return "Reply{" +
                "replyId=" + replyId +
                ", replyContent='" + replyContent + '\'' +
                ", replyDate=" + replyDate +
                ", replyAppid=" + replyAppid +
                ", replyPerson=" + replyPerson +
                ", replyType=" + replyType +
                '}';
    }
}