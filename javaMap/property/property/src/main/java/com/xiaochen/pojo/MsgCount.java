package com.xiaochen.pojo;

public class MsgCount {
    private Integer msgcountId;

    private Integer msgcountPid;

    private Integer msgcountUid;

    private String msgcountReadtime;

    public Integer getMsgcountId() {
        return msgcountId;
    }

    public void setMsgcountId(Integer msgcountId) {
        this.msgcountId = msgcountId;
    }

    public Integer getMsgcountPid() {
        return msgcountPid;
    }

    public void setMsgcountPid(Integer msgcountPid) {
        this.msgcountPid = msgcountPid;
    }

    public Integer getMsgcountUid() {
        return msgcountUid;
    }

    public void setMsgcountUid(Integer msgcountUid) {
        this.msgcountUid = msgcountUid;
    }

    public String getMsgcountReadtime() {
        return msgcountReadtime;
    }

    public void setMsgcountReadtime(String msgcountReadtime) {
        this.msgcountReadtime = msgcountReadtime;
    }


    @Override
    public String toString() {
        return "MsgCount{" +
                "msgcountId=" + msgcountId +
                ", msgcountPid=" + msgcountPid +
                ", msgcountUid=" + msgcountUid +
                ", msgcountReadtime='" + msgcountReadtime + '\'' +
                '}';
    }
}