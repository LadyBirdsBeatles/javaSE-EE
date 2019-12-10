package com.itoyokado.cms.entity;

import java.util.Date;

/**
 * 运单详情
 */
public class Waybill_Detail {
    //主键id
    private Integer id;
    //运单ID
    private Integer waybill_id;
    //操作时间（毫秒数）
    private Date created_date;
    //备注信息（签收、退货等信息）
    private String text;
    //操作人id
    private Integer operator_id;
    //状态（0：提交订单（等待配送），1：开始配送，2：配送完成，3：用户拒收）
    private Integer status;

    public Waybill_Detail(Integer id, Integer waybill_id, Date created_date, String text, Integer operator_id, Integer status) {
        this.id = id;
        this.waybill_id = waybill_id;
        this.created_date = created_date;
        this.text = text;
        this.operator_id = operator_id;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getWaybill_id() {
        return waybill_id;
    }

    public void setWaybill_id(Integer waybill_id) {
        this.waybill_id = waybill_id;
    }

    public Date getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getOperator_id() {
        return operator_id;
    }

    public void setOperator_id(Integer operator_id) {
        this.operator_id = operator_id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
