package com.itoyokado.cms.entity;

import java.util.Date;

/**
 * 公司(分公司)
 */
public class Company {
    //主键id
    private Integer id;
    //公司名称
    private String name;
    //公司法人
    private String jurisdical_person;
    //公司地址
    private String address;
    //公司联系人
    private String contact_name;
    //公司电话
    private Date contact_tel;
    //创建时间(毫秒数)
    private Integer created_date;

    public Company(Integer id, String name, String jurisdical_person, String address, String contact_name, Date contact_tel, Integer created_date) {
        this.id = id;
        this.name = name;
        this.jurisdical_person = jurisdical_person;
        this.address = address;
        this.contact_name = contact_name;
        this.contact_tel = contact_tel;
        this.created_date = created_date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJurisdical_person() {
        return jurisdical_person;
    }

    public void setJurisdical_person(String jurisdical_person) {
        this.jurisdical_person = jurisdical_person;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact_name() {
        return contact_name;
    }

    public void setContact_name(String contact_name) {
        this.contact_name = contact_name;
    }

    public Date getContact_tel() {
        return contact_tel;
    }

    public void setContact_tel(Date contact_tel) {
        this.contact_tel = contact_tel;
    }

    public Integer getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Integer created_date) {
        this.created_date = created_date;
    }
}
