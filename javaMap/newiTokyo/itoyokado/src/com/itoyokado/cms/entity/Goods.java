package com.itoyokado.cms.entity;

/**
 * 商品信息
 */
public class Goods {
    //主键id
    private Integer id;
    //分类ID
    private Integer category_id;
    //商品重量
    private String goods_weight;
    //货物名称
    private String goods_name;

    public Goods(Integer id, Integer category_id, String goods_weight, String goods_name) {
        this.id = id;
        this.category_id = category_id;
        this.goods_weight = goods_weight;
        this.goods_name = goods_name;
    }

    public Goods() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    public String getGoods_weight() {
        return goods_weight;
    }

    public void setGoods_weight(String goods_weight) {
        this.goods_weight = goods_weight;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", category_id=" + category_id +
                ", goods_weight='" + goods_weight + '\'' +
                ", goods_name='" + goods_name + '\'' +
                '}';
    }
}
