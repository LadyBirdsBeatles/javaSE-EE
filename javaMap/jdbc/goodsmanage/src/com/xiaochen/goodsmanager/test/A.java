package com.xiaochen.goodsmanager.test;

import com.xiaochen.goodsmanager.entity.Pagelimit;

import java.lang.reflect.Field;

public class A {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public static void main(String[] args) {
        try{
            Class<A> c=A.class;
            Field field= c.getDeclaredField("name");//获取字段
            Object obj=c.newInstance();//实例化对象
            field.set(obj, "aaa");//为字段赋值
            System.out.println(field.get(obj));
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public <T> Pagelimit pageLimit(T t, Integer  pageNumber, Integer pageSize ){
        Pagelimit pageBean=new Pagelimit(pageNumber,pageSize);
        return pageBean;
    }
}