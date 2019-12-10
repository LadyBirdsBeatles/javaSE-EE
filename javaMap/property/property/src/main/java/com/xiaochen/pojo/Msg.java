package com.xiaochen.pojo;

import java.util.List;

public class Msg {
    private Integer msgId;

    private String msgTitle;

    private String msgPartstarttime;

    private String msgPartendtime;

    private String msgCreatetime;

    private Integer msgPartstate;

    private String msgAdmin;

    private Integer msgClass;

    private String msgOther1;

    private Integer msgOther2;

    private String msgOther3;

    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Integer getMsgId() {
        return msgId;
    }

    public Integer getMsgOther2() {
        return msgOther2;
    }

    public void setMsgOther2(Integer msgOther2) {
        this.msgOther2 = msgOther2;
    }

    public void setMsgId(Integer msgId) {
        this.msgId = msgId;
    }

    public String getMsgTitle() {
        return msgTitle;
    }

    public void setMsgTitle(String msgTitle) {
        this.msgTitle = msgTitle == null ? null : msgTitle.trim();
    }

    public String getMsgPartstarttime() {
        return msgPartstarttime;
    }

    public void setMsgPartstarttime(String msgPartstarttime) {
        this.msgPartstarttime = msgPartstarttime;
    }

    public String getMsgPartendtime() {
        return msgPartendtime;
    }

    public void setMsgPartendtime(String msgPartendtime) {
        this.msgPartendtime = msgPartendtime;
    }

    public String getMsgCreatetime() {
        return msgCreatetime;
    }

    public void setMsgCreatetime(String msgCreatetime) {
        this.msgCreatetime = msgCreatetime;
    }

    public Integer getMsgPartstate() {
        return msgPartstate;
    }

    public void setMsgPartstate(Integer msgPartstate) {
        this.msgPartstate = msgPartstate;
    }

    public String getMsgAdmin() {
        return msgAdmin;
    }

    public void setMsgAdmin(String msgAdmin) {
        this.msgAdmin = msgAdmin == null ? null : msgAdmin.trim();
    }

    public Integer getMsgClass() {
        return msgClass;
    }

    public void setMsgClass(Integer msgClass) {
        this.msgClass = msgClass;
    }

    public String getMsgOther1() {
        return msgOther1;
    }

    public void setMsgOther1(String msgOther1) {
        this.msgOther1 = msgOther1 == null ? null : msgOther1.trim();
    }

    public String getMsgOther3() {
        return msgOther3;
    }

    public void setMsgOther3(String msgOther3) {
        this.msgOther3 = msgOther3 == null ? null : msgOther3.trim();
    }


    @Override
    public String toString() {
        return "Msg{" +
                "msgId=" + msgId +
                ", msgTitle='" + msgTitle + '\'' +
                ", msgPartstarttime='" + msgPartstarttime + '\'' +
                ", msgPartendtime='" + msgPartendtime + '\'' +
                ", msgCreatetime='" + msgCreatetime + '\'' +
                ", msgPartstate=" + msgPartstate +
                ", msgAdmin='" + msgAdmin + '\'' +
                ", msgClass=" + msgClass +
                ", msgOther1='" + msgOther1 + '\'' +
                ", msgOther2=" + msgOther2 +
                ", msgOther3='" + msgOther3 + '\'' +
                ", users=" + users +
                '}';
    }
}