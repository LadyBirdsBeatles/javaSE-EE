package com.itoyokado.cms.entity;

import java.util.Date;

/**
 * 客服端版本信息
 */
public class Cient_Version {
    //主键ID
    private Integer id;
    //版本号
    private Integer version_code;
    //版本名称
    private String version_name;
    //版本说明
    private String text;
    //是否强制更新
    private Date is_force;
    //更新时间（毫秒数）
    private Integer time;
    //下载链接
    private String download_link;

    public Cient_Version(Integer id, Integer version_code, String version_name, String text, Date is_force, Integer time, String download_link) {
        this.id = id;
        this.version_code = version_code;
        this.version_name = version_name;
        this.text = text;
        this.is_force = is_force;
        this.time = time;
        this.download_link = download_link;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVersion_code() {
        return version_code;
    }

    public void setVersion_code(Integer version_code) {
        this.version_code = version_code;
    }

    public String getVersion_name() {
        return version_name;
    }

    public void setVersion_name(String version_name) {
        this.version_name = version_name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getIs_force() {
        return is_force;
    }

    public void setIs_force(Date is_force) {
        this.is_force = is_force;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public String getDownload_link() {
        return download_link;
    }

    public void setDownload_link(String download_link) {
        this.download_link = download_link;
    }
}
