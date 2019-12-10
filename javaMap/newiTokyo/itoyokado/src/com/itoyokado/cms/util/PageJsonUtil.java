package com.itoyokado.cms.util;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 返回layui分页规定的参数
 */
public class PageJsonUtil {
    public static JSONObject pageJson(int status, String message, int total, JSONArray jsonArr){
        JSONObject jsonObject = new JSONObject();
        JSONObject jsonmain = new JSONObject();
        jsonObject.put("item",jsonArr);
        jsonmain.put("status", status);
        jsonmain.put("message", message);
        jsonmain.put("total", total);
        jsonmain.put("rows", jsonObject);
        return jsonmain;
    }
}
