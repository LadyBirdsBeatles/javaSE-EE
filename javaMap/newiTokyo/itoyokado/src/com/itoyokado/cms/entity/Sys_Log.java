package com.itoyokado.cms.entity;

import java.util.Date;

/**
 * 系统日志
 */
public class Sys_Log {
    //主键id
    private Integer id;
    //客服端ip
    private String ip_address;
    //用户名
    private String username;
    //时间(毫秒数)
    private Date created_date;
    //登陆设备
    private String device;
    //操作信息
    private String msg;
    //工号
    private String sys_user_job_number;
    //用户id
    private Integer sys_user_id;
    //请求资源签名
    private String request_signature;
    // 操作资源
    private String resource;
    //请求头
    private String request_headers;
    //请求参数
    private String parameters;
    //响应头
    private String response_headers;
    //响应内容
    private String response;
    //用户类型
    private Integer sys_user_type;

    public Sys_Log(Integer id, String ip_address, String username, Date created_date, String device, String msg, String sys_user_job_number, Integer sys_user_id, String request_signature, String resource, String request_headers, String parameters, String response_headers, String response, Integer sys_user_type) {
        this.id = id;
        this.ip_address = ip_address;
        this.username = username;
        this.created_date = created_date;
        this.device = device;
        this.msg = msg;
        this.sys_user_job_number = sys_user_job_number;
        this.sys_user_id = sys_user_id;
        this.request_signature = request_signature;
        this.resource = resource;
        this.request_headers = request_headers;
        this.parameters = parameters;
        this.response_headers = response_headers;
        this.response = response;
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

    public String getRequest_signature() {
        return request_signature;
    }

    public void setRequest_signature(String request_signature) {
        this.request_signature = request_signature;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getRequest_headers() {
        return request_headers;
    }

    public void setRequest_headers(String request_headers) {
        this.request_headers = request_headers;
    }

    public String getParameters() {
        return parameters;
    }

    public void setParameters(String parameters) {
        this.parameters = parameters;
    }

    public String getResponse_headers() {
        return response_headers;
    }

    public void setResponse_headers(String response_headers) {
        this.response_headers = response_headers;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public Integer getSys_user_type() {
        return sys_user_type;
    }

    public void setSys_user_type(Integer sys_user_type) {
        this.sys_user_type = sys_user_type;
    }
}
