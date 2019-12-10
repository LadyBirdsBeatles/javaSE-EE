package com.itoyokado.cms.entity;

import java.util.Date;

/**
 *手持设备
 */
public class Handheld_Device {
    //主键ID
    private Integer id;
    //设备编号
    private String device_no;
    //设备名称
    private String name;
    //设备描述
    private String description;
    //设备类型（0：手持机，1：扫描红外线扫描枪）
    private Integer type;
    //所属公司
    private Date company_id;
    //创建时间（毫秒数）
    private Integer created_date;

    public Handheld_Device(Integer id, String device_no, String name, String description, Integer type, Date company_id, Integer created_date) {
        this.id = id;
        this.device_no = device_no;
        this.name = name;
        this.description = description;
        this.type = type;
        this.company_id = company_id;
        this.created_date = created_date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDevice_no() {
        return device_no;
    }

    public void setDevice_no(String device_no) {
        this.device_no = device_no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getCompany_id() {
        return company_id;
    }

    public void setCompany_id(Date company_id) {
        this.company_id = company_id;
    }

    public Integer getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Integer created_date) {
        this.created_date = created_date;
    }
}
