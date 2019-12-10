package com.xiaochen.goodsmanager.entity;

import java.io.Serializable;
import java.util.List;
/**
 * 分页Bean
 */
public class Pagelimit<T>implements Serializable {
    private Integer pagrStart=1;//起始页
    private Integer pageSize=10;//每页的记录
    private Integer pageCount;//总的页数
    private Integer pageRow;//总的记录数
    private List<T> list;//数据
    public Pagelimit(){
    }
    //获取总页数
    public Pagelimit(Integer pageRow, Integer pageSize){
          setPageRow(pageRow);
          setPageSize(pageSize);
          pageCount=pageRow%pageSize==0?pageRow/pageSize:pageRow/pageSize+1;
    }
    public Integer getPagrStart() {
        return pagrStart;
    }

    public void setPagrStart(Integer pagrStart) {
        this.pagrStart = pagrStart;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Integer getPageRow() {
        return pageRow;
    }

    public void setPageRow(Integer pageRow) {
        this.pageRow = pageRow;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Pagelimit{" +
                "pagrStart=" + pagrStart +
                ", pageSize=" + pageSize +
                ", pageCount=" + pageCount +
                ", pageRow=" + pageRow +
                ", list=" + list +
                '}';
    }
}
