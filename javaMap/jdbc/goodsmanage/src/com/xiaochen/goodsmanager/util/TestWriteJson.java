package com.xiaochen.goodsmanager.util;

import com.xiaochen.goodsmanager.entity.Admin;
import net.sf.json.JSONArray;

public class TestWriteJson {
    public  String jsonbean(Object t) {
        JSONArray jSONArray = JSONArray.fromObject(t);
        String jsonJAVA = jSONArray.toString();
         return jsonJAVA;
    }
}
