package com.itoyokado.cms.entity;

/**
 * itoyokad实体聚合
 */
public class Gather {
    //手持端授权码
    private   Access_Token access_token;
    //购买商品信息
    private  Buy_Goods buy_goods;
    //客服端版本信息
    private   Cient_Version cient_version;
    //公司(分公司)
    private  Company company;
    //货物信息
    private  Goods goods;
    //货物分类
    private  Goods_Category goods_category;
    //手持端设备
    private  Handheld_Device handheld_device;
    //仓库(配送中心)
    private Storehouse storehouse;
    //系统日志
    private  Sys_Log sys_log;
    //系统登陆或退出日志
    private  Sys_Login_Out_Log sys_login_out_log;
    //系统用户
    private Sys_User sys_user;
    //系统用户权限
    private   Sys_User_Authority sys_user_authority;
    //系统用户手持设备关联表
    private Sys_User_Handheld_Device sys_user_handheld_device;
    //地图信息
    private T_Map t_map;
    //用户信息
    private  User user;
    //用户权限
    private User_Authority user_authority;
    //运单
    private  Waybill waybill;
    //运单详情
    private Waybill_Detail waybill_detail;

    public Gather() {
        this.access_token = access_token;
        this.buy_goods = buy_goods;
        this.cient_version = cient_version;
        this.company = company;
        this.goods = goods;
        this.goods_category = goods_category;
        this.handheld_device = handheld_device;
        this.storehouse = storehouse;
        this.sys_log = sys_log;
        this.sys_login_out_log = sys_login_out_log;
        this.sys_user = sys_user;
        this.sys_user_authority = sys_user_authority;
        this.sys_user_handheld_device = sys_user_handheld_device;
        this.t_map = t_map;
        this.user = user;
        this.user_authority = user_authority;
        this.waybill = waybill;
        this.waybill_detail = waybill_detail;
    }

    public Access_Token getAccess_token() {
        return access_token;
    }

    public void setAccess_token(Access_Token access_token) {
        this.access_token = access_token;
    }

    public Buy_Goods getBuy_goods() {
        return buy_goods;
    }

    public void setBuy_goods(Buy_Goods buy_goods) {
        this.buy_goods = buy_goods;
    }

    public Cient_Version getCient_version() {
        return cient_version;
    }

    public void setCient_version(Cient_Version cient_version) {
        this.cient_version = cient_version;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Goods_Category getGoods_category() {
        return goods_category;
    }

    public void setGoods_category(Goods_Category goods_category) {
        this.goods_category = goods_category;
    }

    public Handheld_Device getHandheld_device() {
        return handheld_device;
    }

    public void setHandheld_device(Handheld_Device handheld_device) {
        this.handheld_device = handheld_device;
    }

    public Storehouse getStorehouse() {
        return storehouse;
    }

    public void setStorehouse(Storehouse storehouse) {
        this.storehouse = storehouse;
    }

    public Sys_Log getSys_log() {
        return sys_log;
    }

    public void setSys_log(Sys_Log sys_log) {
        this.sys_log = sys_log;
    }

    public Sys_Login_Out_Log getSys_login_out_log() {
        return sys_login_out_log;
    }

    public void setSys_login_out_log(Sys_Login_Out_Log sys_login_out_log) {
        this.sys_login_out_log = sys_login_out_log;
    }

    public Sys_User getSys_user() {
        return sys_user;
    }

    public void setSys_user(Sys_User sys_user) {
        this.sys_user = sys_user;
    }

    public Sys_User_Authority getSys_user_authority() {
        return sys_user_authority;
    }

    public void setSys_user_authority(Sys_User_Authority sys_user_authority) {
        this.sys_user_authority = sys_user_authority;
    }

    public Sys_User_Handheld_Device getSys_user_handheld_device() {
        return sys_user_handheld_device;
    }

    public void setSys_user_handheld_device(Sys_User_Handheld_Device sys_user_handheld_device) {
        this.sys_user_handheld_device = sys_user_handheld_device;
    }

    public T_Map getT_map() {
        return t_map;
    }

    public void setT_map(T_Map t_map) {
        this.t_map = t_map;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User_Authority getUser_authority() {
        return user_authority;
    }

    public void setUser_authority(User_Authority user_authority) {
        this.user_authority = user_authority;
    }

    public Waybill getWaybill() {
        return waybill;
    }

    public void setWaybill(Waybill waybill) {
        this.waybill = waybill;
    }

    public Waybill_Detail getWaybill_detail() {
        return waybill_detail;
    }

    public void setWaybill_detail(Waybill_Detail waybill_detail) {
        this.waybill_detail = waybill_detail;
    }
}
