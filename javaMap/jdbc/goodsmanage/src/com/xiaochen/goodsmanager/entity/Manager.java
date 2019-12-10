package com.xiaochen.goodsmanager.entity;

/**
 * 总管理
 */
public class Manager {
    private Admin admin; //管理员
    private Goods goods;//商品
    private Employee employee;//员工
    private Particulars particulars; //商品详情
    private Repertory repertory;// 库存

    public Manager() {
    }

    public Manager(Admin admin, Goods goods, Employee employee, Particulars particulars, Repertory repertory) {
        this.admin = admin;
        this.goods = goods;
        this.employee = employee;
        this.particulars = particulars;
        this.repertory = repertory;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Particulars getParticulars() {
        return particulars;
    }

    public void setParticulars(Particulars particulars) {
        this.particulars = particulars;
    }

    public Repertory getRepertory() {
        return repertory;
    }

    public void setRepertory(Repertory repertory) {
        this.repertory = repertory;
    }
}
