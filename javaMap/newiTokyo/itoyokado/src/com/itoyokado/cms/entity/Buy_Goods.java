package com.itoyokado.cms.entity;

/**
 * 购买的货物信息
 */
public class Buy_Goods {
    //主键id
    private Integer id;
    // 货物id
    private Integer goods_id;
    //分类ID
    private Integer category_id;
    //货物名称
    private String goods_name;
    //货物数量
    private Integer goods_weight;
    //所属运单ID
    private Integer waybill_id;

    public Buy_Goods() {
    }

    public Buy_Goods(Integer id, Integer goods_id, Integer category_id, String goods_name, Integer goods_weight, Integer waybill_id) {
        this.id = id;
        this.goods_id = goods_id;
        this.category_id = category_id;
        this.goods_name = goods_name;
        this.goods_weight = goods_weight;
        this.waybill_id = waybill_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(Integer goods_id) {
        this.goods_id = goods_id;
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public Integer getGoods_weight() {
        return goods_weight;
    }

    public void setGoods_weight(Integer goods_weight) {
        this.goods_weight = goods_weight;
    }

    public Integer getWaybill_id() {
        return waybill_id;
    }

    public void setWaybill_id(Integer waybill_id) {
        this.waybill_id = waybill_id;
    }
}
