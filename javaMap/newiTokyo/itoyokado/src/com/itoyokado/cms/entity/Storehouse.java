package com.itoyokado.cms.entity;

import java.util.Date;

/**
 * 仓库管理
 */
public class Storehouse {
    //主键id
    private Integer id;
    //仓库名称
    private String name;
    //仓库地址
    private String address;
    //仓库联系人姓名
    private String contact_name;
    //仓库联系人电话
    private String contact_tel;
    //经度
    private double lng;
    //维度
    private double lat;
    //所属公司
    private Integer company_id;
    //创建世间(毫秒数)
    private Date created_date;
    //上次修改时间
    private Date last_modified_date;

    public Storehouse(Integer id, String name, String address, String contact_name, String contact_tel, double lng, double lat, Integer company_id, Date created_date, Date last_modified_date) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.contact_name = contact_name;
        this.contact_tel = contact_tel;
        this.lng = lng;
        this.lat = lat;
        this.company_id = company_id;
        this.created_date = created_date;
        this.last_modified_date = last_modified_date;
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

    public String getContact_tel() {
        return contact_tel;
    }

    public void setContact_tel(String contact_tel) {
        this.contact_tel = contact_tel;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public Integer getCompany_id() {
        return company_id;
    }

    public void setCompany_id(Integer company_id) {
        this.company_id = company_id;
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
}
