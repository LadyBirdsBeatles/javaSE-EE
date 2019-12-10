package com.itoyokado.cms.entity;

import java.util.Date;

/***
 * 系统用户
 */
public class Sys_User {
    //主键id
    private Integer id;
    //工号
    private String job_number;
    //用户头像
    private String avatar;
    //用户名
    private String s_name;
    //密码（MD5（明文密码+工号））
    private String s_password;
    //创建日期（毫秒数）
    private Date created_date;
    //上次修改时间（毫秒数）
    private Date last_modified_date;
    //上次退出日期（毫秒数）
    private Date last_logout_date;
    //最后登录日期（毫秒数）
    private Date last_login_date;
    //最后登录IP地址
    private String last_login_ip;
    //手机号码
    private String s_tel;
    //所属公司
    private Integer company_id;
    //类型（0：管理人员，1：客服，2：配送员）
    private Integer type;
    //身份证号
    private String id_card;

    public Sys_User(Integer id, String job_number, String avatar, String name, String password, Date created_date, Date last_modified_date, Date last_logout_date, Date last_login_date, String last_login_ip, String tel, Integer company_id, Integer type, String id_card) {
        this.id = id;
        this.job_number = job_number;
        this.avatar = avatar;
        this.s_name = name;
        this.s_password = password;
        this.created_date = created_date;
        this.last_modified_date = last_modified_date;
        this.last_logout_date = last_logout_date;
        this.last_login_date = last_login_date;
        this.last_login_ip = last_login_ip;
        this.s_tel = tel;
        this.company_id = company_id;
        this.type = type;
        this.id_card = id_card;
    }
    public Sys_User(){

    }

    @Override
    public String toString() {
        return "Sys_User{" +
                "id=" + id +
                ", job_number='" + job_number + '\'' +
                ", avatar='" + avatar + '\'' +
                ", s_name='" + s_name + '\'' +
                ", s_password='" + s_password + '\'' +
                ", created_date=" + created_date +
                ", last_modified_date=" + last_modified_date +
                ", last_logout_date=" + last_logout_date +
                ", last_login_date=" + last_login_date +
                ", last_login_ip='" + last_login_ip + '\'' +
                ", s_tel='" + s_tel + '\'' +
                ", company_id=" + company_id +
                ", type=" + type +
                ", id_card='" + id_card + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJob_number() {
        return job_number;
    }

    public void setJob_number(String job_number) {
        this.job_number = job_number;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public String getS_password() {
        return s_password;
    }

    public void setS_password(String s_password) {
        this.s_password = s_password;
    }

    public Date getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }

    public Date getLast_modified_date() {
        return last_modified_date;
    }

    public void setLast_modified_date(Date last_modified_date) {
        this.last_modified_date = last_modified_date;
    }

    public Date getLast_logout_date() {
        return last_logout_date;
    }

    public void setLast_logout_date(Date last_logout_date) {
        this.last_logout_date = last_logout_date;
    }

    public Date getLast_login_date() {
        return last_login_date;
    }

    public void setLast_login_date(Date last_login_date) {
        this.last_login_date = last_login_date;
    }

    public String getLast_login_ip() {
        return last_login_ip;
    }

    public void setLast_login_ip(String last_login_ip) {
        this.last_login_ip = last_login_ip;
    }

    public String getS_tel() {
        return s_tel;
    }

    public void setS_tel(String s_tel) {
        this.s_tel = s_tel;
    }

    public Integer getCompany_id() {
        return company_id;
    }

    public void setCompany_id(Integer company_id) {
        this.company_id = company_id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getId_card() {
        return id_card;
    }

    public void setId_card(String id_card) {
        this.id_card = id_card;
    }


}
