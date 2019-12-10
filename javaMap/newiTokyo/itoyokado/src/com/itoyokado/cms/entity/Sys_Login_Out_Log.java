package com.itoyokado.cms.entity;

import java.util.Date;

/**
 * 系统登陆日志
 */
public class Sys_Login_Out_Log {
    //主键id
    private Integer id;
    //客服端IP
    private String ip_address;
    //用户名
    private String username;
    //时间(毫秒数)
    private Date created_date;
    //登陆的设备
    private String device;
    //操作信息
    private String msg;
    //操作资源(登陆/退出)
    private String resource;
    //工号
    private String sys_user_job_number;
    //用户id
    private Integer sys_user_id;
    //用户类型
    private Integer sys_user_type;

    public Sys_Login_Out_Log(Integer id, String ip_address, String username, Date created_date, String device, String msg, String resource, String sys_user_job_number, Integer sys_user_id, Integer sys_user_type) {
        this.id = id;
        this.ip_address = ip_address;
        this.username = username;
        this.created_date = created_date;
        this.device = device;
        this.msg = msg;
        this.resource = resource;
        this.sys_user_job_number = sys_user_job_number;
        this.sys_user_id = sys_user_id;
        this.sys_user_type = sys_user_type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIp_address() {
        return ip_address;
    }

    public void setIp_address(String ip_address) {
        this.ip_address = ip_address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getSys_user_job_number() {
        return sys_user_job_number;
    }

    public void setSys_user_job_number(String sys_user_job_number) {
        this.sys_user_job_number = sys_user_job_number;
    }

    public Integer getSys_user_id() {
        return sys_user_id;
    }

    public void setSys_user_id(Integer sys_user_id) {
        this.sys_user_id = sys_user_id;
    }

    public Integer getSys_user_type() {
        return sys_user_type;
    }

    public void setSys_user_type(Integer sys_user_type) {
        this.sys_user_type = sys_user_type;
    }
}
