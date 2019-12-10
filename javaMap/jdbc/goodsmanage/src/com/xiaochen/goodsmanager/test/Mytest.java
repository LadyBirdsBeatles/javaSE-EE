package com.xiaochen.goodsmanager.test;

import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonMapFormatVisitor;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.xiaochen.goodsmanager.entity.Admin;
import com.xiaochen.goodsmanager.view.*;
import net.sf.json.JSONArray;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Mytest {
    public static void main(String[] args) {
        /*Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String newdate = format.format(date);
        System.out.println(newdate);
        Ui ui = new Ui();
        ui.show();
        System.out.println(newdate);*/
        Admin admin = new Admin();
        admin.setPwd("10001");
        admin.setAccount("99999");
        JSONArray jSONArray = JSONArray.fromObject(admin);
        String jsonJAVA = jSONArray.toString();
        System.out.println(jsonJAVA);
    }
}
