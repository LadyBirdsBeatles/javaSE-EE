package com.itoyokado.cms.entity;

/**
 * 商品详情
 */
public class Goods_Category {
    //主键id
    private Integer id;
    //商品名称
    private String category_name;
    // 父级id
    private Integer parent_id;
    //状态
    private Integer statu;

    public Goods_Category(Integer id, String category_name, Integer parent_id, Integer statu) {
        this.id = id;
        this.category_name = category_name;
        this.parent_id = parent_id;
        this.statu = statu;
    }

    public Goods_Category() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public Integer getParent_id() {
        return parent_id;
    }

    public void setParent_id(Integer parent_id) {
        this.parent_id = parent_id;
    }

    public Integer getStatu() {
        return statu;
    }

    public void setStatu(Integer statu) {
        this.statu = statu;
    }
}
