package com.xiaochen.util;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.List;

/**
 * 返回layui分页规定的参数
 */
public class Tojsons {
    public static JSONObject layuiJson(int total, List list){
        JSONObject jsonObject = new JSONObject();
        JSONObject jsonmain = new JSONObject();
        JSONArray jsonArray = JSONArray.fromObject(list);
        jsonObject.put("item",jsonArray);
        jsonmain.put("status", 200);
        jsonmain.put("message", "");
        jsonmain.put("total", total);
        jsonmain.put("rows", jsonObject);
        return jsonmain;
    }
    public static JSONObject layuiJsonCall(int rows, List list){
        JSONObject jsonObject = new JSONObject();
        JSONObject jsonmain = new JSONObject();
        JSONArray jsonArray = JSONArray.fromObject(list);
        jsonObject.put("item",jsonArray);
        jsonmain.put("status", 200);
        jsonmain.put("message", "");
        jsonmain.put("total", rows);
        jsonmain.put("rows", jsonObject);
        return jsonmain;
    }
}
