package com.itoyokado.cms.entity;

import java.util.Date;

/**
 * 运单
 */
public class Waybill {
    //主键id
    private Integer id;
    //系统运单号
    private String sys_no;
    //货物运单号
    private String goods_no;
    //寄货费用（单位：分）
    private Integer cost;
    //开始配送时间（毫秒数）
    private Date distribution_date;
    //预计到达时间（毫秒数）
    private Date eta;
    //完成时间（毫秒数）
    private Date finish_time;
    //收货人ID
    private Integer consignee_id;
    //收货人的地址
    private String consignee_address;
    //发货人地址
    private String consignor_address;
    //订单状态描述
    private String status_desc;
    //完成方式（0：正常完成，1：寄放完成，2：收到退货）
    private Integer completion_status;
    //所属公司
    private Integer company_id;
    //所属区域
    private String area;
    //下单时间（毫秒数）
    private Date created_date;
    //上次修改时间（毫秒数）
    private Date last_modified_date;
    //制单人ID或配送人ID
    private Integer sys_user_id;
    //配送地址纬度
    private double lat;
    //配送地址经度
    private double lng;
    //计划配送开始时间（毫秒数）
    private Date planned_start_time;
    //计划配送结束时间（毫秒数）
    private Date planned_end_time;
    private double goods_price;
    private Integer box_id;
    private String pay_way;

    public Waybill(Integer id, String sys_no, String goods_no, Integer cost, Date distribution_date, Date eta, Date finish_time, Integer consignee_id, String consignee_address, String consignor_address, Integer status, String status_desc, Integer completion_status, Integer company_id, String area, Date created_date, Date last_modified_date, Integer sys_user_id, double lat, double lng, Date planned_start_time, Date planned_end_time) {
        this.id = id;
        this.sys_no = sys_no;
        this.goods_no = goods_no;
        this.cost = cost;
        this.distribution_date = distribution_date;
        this.eta = eta;
        this.finish_time = finish_time;
        this.consignee_id = consignee_id;
        this.consignee_address = consignee_address;
        this.consignor_address = consignor_address;
        this.status_desc = status_desc;
        this.completion_status = completion_status;
        this.company_id = company_id;
        this.area = area;
        this.created_date = created_date;
        this.last_modified_date = last_modified_date;
        this.sys_user_id = sys_user_id;
        this.lat = lat;
        this.lng = lng;
        this.planned_start_time = planned_start_time;
        this.planned_end_time = planned_end_time;
    }

    public Waybill() {
    }

    public double getGoods_price() {
        return goods_price;
    }

    public void setGoods_price(double goods_price) {
        this.goods_price = goods_price;
    }

    public Integer getBox_id() {
        return box_id;
    }

    public void setBox_id(Integer box_id) {
        this.box_id = box_id;
    }

    public String getPay_way() {
        return pay_way;
    }

    public void setPay_way(String pay_way) {
        this.pay_way = pay_way;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSys_no() {
        return sys_no;
    }

    public void setSys_no(String sys_no) {
        this.sys_no = sys_no;
    }

    public String getGoods_no() {
        return goods_no;
    }

    public void setGoods_no(String goods_no) {
        this.goods_no = goods_no;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Date getDistribution_date() {
        return distribution_date;
    }

    public void setDistribution_date(Date distribution_date) {
        this.distribution_date = distribution_date;
    }

    public Date getEta() {
        return eta;
    }

    public void setEta(Date eta) {
        this.eta = eta;
    }

    public Date getFinish_time() {
        return finish_time;
    }

    public void setFinish_time(Date finish_time) {
        this.finish_time = finish_time;
    }

    public Integer getConsignee_id() {
        return consignee_id;
    }

    public void setConsignee_id(Integer consignee_id) {
        this.consignee_id = consignee_id;
    }

    public String getConsignee_address() {
        return consignee_address;
    }

    public void setConsignee_address(String consignee_address) {
        this.consignee_address = consignee_address;
    }

    public String getConsignor_address() {
        return consignor_address;
    }

    public void setConsignor_address(String consignor_address) {
        this.consignor_address = consignor_address;
    }
    public String getStatus_desc() {
        return status_desc;
    }

    public void setStatus_desc(String status_desc) {
        this.status_desc = status_desc;
    }

    public Integer getCompletion_status() {
        return completion_status;
    }

    public void setCompletion_status(Integer completion_status) {
        this.completion_status = completion_status;
    }

    public Integer getCompany_id() {
        return company_id;
    }

    public void setCompany_id(Integer company_id) {
        this.company_id = company_id;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
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

    public Integer getSys_user_id() {
        return sys_user_id;
    }

    public void setSys_user_id(Integer sys_user_id) {
        this.sys_user_id = sys_user_id;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public Date getPlanned_start_time() {
        return planned_start_time;
    }

    public void setPlanned_start_time(Date planned_start_time) {
        this.planned_start_time = planned_start_time;
    }

    public Date getPlanned_end_time() {
        return planned_end_time;
    }

    public void setPlanned_end_time(Date planned_end_time) {
        this.planned_end_time = planned_end_time;
    }
}
